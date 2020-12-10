package or.talend.components.lib.googlestorage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobInfo;

public class UploadChunkThread implements Runnable {
    
    private final WriteChannel writeChannel; 
    
    private final BlobInfo targetBlob;
    
    private final InputStream source;
    
    private final int bufferSize;
    
    private boolean done;
    
    private boolean failed;
    
    private Exception exception;
    
    public UploadChunkThread(WriteChannel writeChannel, BlobInfo targetBlob, InputStream source, int bufferSize) {
        this.writeChannel = writeChannel;
        this.targetBlob = targetBlob;
        this.source = source;
        this.bufferSize = bufferSize;
    }
    
    @Override
    public void run() {
       byte[] buffer = new byte[bufferSize];
       int read;
       try {
           while((read = source.read(buffer)) > 0) {
               writeChannel.write(ByteBuffer.wrap(buffer, 0, read));
           }
           writeChannel.close();
           source.close();
       } catch (IOException ioe) {
           ioe.printStackTrace();
           failed = true;
           exception = ioe;
       }
       
       done = true;
       System.out.println(targetBlob + " uploaded.");
    }
    
    
    public boolean isDone() {
        return done;
    }
    
    
    public BlobInfo getTargetBlob() {
        return targetBlob;
    }
    
    
    public boolean isFailed() {
        return failed;
    }
    
    
    public Exception getException() {
        return exception;
    }
    

}
