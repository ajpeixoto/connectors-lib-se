package or.talend.components.lib.googlestorage;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.ComposeRequest;

public class StorageCompositeParallelUploader {
    
    public static class Builder {
        
        private StorageCompositeParallelUploader bean;
        
        public Builder(Storage storage, String bucket, String fileToUpload, String targetBlob) {
            bean = new StorageCompositeParallelUploader(storage, bucket, fileToUpload, targetBlob);
        }
        
        public Builder withTempPath(String tempPath) {
            bean.setTempPath(tempPath);
            return this;
        }
        
        public Builder withChunkSize(int chunkSize) {
            bean.setChunkSize(chunkSize);
            return this;
        }
        
        public Builder withInitialThreadCount(int initialThreadCount) {
            bean.setInitialThreadCount(initialThreadCount);
            return this;
        }
        
        public Builder withMaxThreadCount(int maxThreadCount) {
            bean.setMaxThreadCount(maxThreadCount);
            return this;
        }
        
        public Builder withtIdleThreadKeepalive(int idleThreadKeepalive) {
            bean.setIdleThreadKeepalive(idleThreadKeepalive);
            return this;
        }
        
        public Builder withIdleThreadUnit(TimeUnit idleThreadUnit) {
            bean.setIdleThreadUnit(idleThreadUnit);
            return this;
        }
        
        public Builder withAwaitTerminationValue(int awaitTerminationValue) {
            bean.setAwaitTerminationValue(awaitTerminationValue);
            return this;
        }
        
        public Builder withAwaitTerminationUnit(TimeUnit awaitTerminationUnit) {
            bean.setAwaitTerminationUnit(awaitTerminationUnit);
            return this;
        }
        
        public Builder withBufferSize(int bufferSize) {
            bean.setBufferSize(bufferSize);
            return this;
        }
        
        public StorageCompositeParallelUploader build() {
            return bean;
        }
    }
    
    private static final int DEFAULT_CHUNK_SIZE = 10 * 1024 * 1024; // 10MB
    
    private static final String DEFAULT_TEMP_PATH = "tmp/";
    
    private static final int DEFAULT_INITIAL_THREAD_COUNT = 1;
    
    private static final int DEFAULT_MAX_THREAD_COUNT = 4;
    
    private static final int DEFAULT_IDLE_THREAD_KEEPALIVE = 5;
    
    private static final TimeUnit DEFAULT_IDLE_THREAD_UNIT = TimeUnit.SECONDS;
    
    private static final int DEFAULT_AWAIT_TERMINATION_VALUE = 10;
    
    private static final TimeUnit DEFAULT_AWAIT_TERMINATION_UNIT = TimeUnit.MINUTES;
    
    private static final int MAX_COMPONENT = 32; // GCS limitation
    
    private static final int DEFAULT_BUFFER_SIZE = 100 * 1024 * 1024;
    
    
    private final Storage storage;
    
    private final String fileToUploadPath;
    
    private final String bucket;
    
    private final String targetBlob;
    
    private String tempPath = DEFAULT_TEMP_PATH;
    
    private int chunkSize = DEFAULT_CHUNK_SIZE; // 50kB
    
    private int initialThreadCount = DEFAULT_INITIAL_THREAD_COUNT;
    
    private int maxThreadCount = DEFAULT_MAX_THREAD_COUNT;
    
    private int idleThreadKeepalive = DEFAULT_IDLE_THREAD_KEEPALIVE;
    
    private TimeUnit idleThreadUnit = DEFAULT_IDLE_THREAD_UNIT;
    
    private int awaitTerminationValue = DEFAULT_AWAIT_TERMINATION_VALUE;
    
    private TimeUnit awaitTerminationUnit = DEFAULT_AWAIT_TERMINATION_UNIT;
    
    private int bufferSize = DEFAULT_BUFFER_SIZE;
    
    private StorageCompositeParallelUploader(Storage storage, String bucket, String fileToUpload, String targetBlob) {
        this.storage = storage;
        this.bucket = bucket;
        this.fileToUploadPath = fileToUpload;
        this.targetBlob = targetBlob;
    }
    
    
    private void setTempPath(String tempPath) {
       this.tempPath = tempPath + (tempPath.endsWith("/") ? "" : "/");
    }
    
    private void setChunkSize(int chunkSize) {
        if (chunkSize <= 0) {
            throw new InvalidParameterException("Chunk size must be positive.");
        }
        this.chunkSize = chunkSize;
    }
    
    private void setInitialThreadCount(int initialThreadCount) {
        if (initialThreadCount < 0) {
            throw new InvalidParameterException("Initial thread count must be positive.");
        }
        this.initialThreadCount = initialThreadCount;
    }
      
    private void setMaxThreadCount(int maxThreadCount) {
        if (maxThreadCount < 0) {
            throw new InvalidParameterException("Max thread count must be positive.");
        }
        if (maxThreadCount < initialThreadCount) {
            throw new InvalidParameterException("Max thread count must be greater than initialThreadCount.");
        }
        this.maxThreadCount = maxThreadCount;
    }
    
    
    private void setIdleThreadKeepalive(int idleThreadKeepalive) {
        this.idleThreadKeepalive = idleThreadKeepalive;
    }
    
    
    private void setIdleThreadUnit(TimeUnit idleThreadUnit) {
        this.idleThreadUnit = idleThreadUnit;
    }
    
    
    private void setAwaitTerminationValue(int awaitTerminationValue) {
        this.awaitTerminationValue = awaitTerminationValue;
    }
    
    
    private void setAwaitTerminationUnit(TimeUnit awaitTerminationUnit) {
        this.awaitTerminationUnit = awaitTerminationUnit;
    }
    
    
    private void setBufferSize(int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("BufferSize must be a positive interger.");
        }
        this.bufferSize = bufferSize;
    }
    
    public void upload() throws InterruptedException {
        File fileToUPload = new File(fileToUploadPath);
        long fileSize = fileToUPload.length();
        String filename = fileToUPload.getName();
        String blobBaseName = filename.substring(0, filename.lastIndexOf('.'));
        
        int nbChunks = ((int)(fileSize / chunkSize)) + (fileSize % chunkSize == 0 ? 0 : 1);
        System.out.println(nbChunks + " chuncks to upload");
        
        ExecutorService executorService = new ThreadPoolExecutor(
                initialThreadCount, maxThreadCount, 
                idleThreadKeepalive, idleThreadUnit, 
                new LinkedBlockingQueue<Runnable>());
        
        List<UploadChunkThread> threads = IntStream.range(0, nbChunks)
                .mapToObj( i -> {
                    BlobInfo blobInfo = BlobInfo.newBuilder(bucket, tempPath + blobBaseName + "_" + i).build();
                    WriteChannel writeChannel = storage.writer(blobInfo);
                    try {
                        return new UploadChunkThread(
                                writeChannel, blobInfo, 
                                new FileChunkInputStream(fileToUPload, ((long) i) * chunkSize, chunkSize),
                                bufferSize);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toList());
        
        threads.stream().forEach(executorService::execute);
        executorService.shutdown();
        executorService.awaitTermination(awaitTerminationValue, awaitTerminationUnit);
        
        List<BlobInfo> chunks = threads.stream().map(UploadChunkThread::getTargetBlob).collect(Collectors.toList());
        
        while(chunks.size() > 0) {
            List<BlobInfo> chunksIteration = chunks.stream().limit(MAX_COMPONENT).collect(Collectors.toList());
            chunks.removeAll(chunksIteration);
            String composeName = chunks.isEmpty() ? targetBlob : (blobBaseName + "_" + UUID.randomUUID());
            BlobInfo target = BlobInfo.newBuilder(bucket, tempPath + composeName).build();
            storage.compose(ComposeRequest.newBuilder()
                    .addSource(chunksIteration.stream().map(BlobInfo::getName).collect(Collectors.toList()))
                    .setTarget(target)
                    .build());
            
            if (!chunks.isEmpty()) {
                chunks.add(0, target);
            }
            
            storage.delete(chunksIteration.stream()
                    .map(blobInfo -> BlobId.of(bucket, blobInfo.getName()))
                    .collect(Collectors.toList()));
            
        }
    }
    
    

}
