package or.talend.components.lib.googlestorage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class FileChunkInputStream extends InputStream {
    
    private final RandomAccessFile raf;
    
    private final long chunkSize;
    
    private long read;
    
    public FileChunkInputStream(File source, long offset, long chunkSize) throws IOException {
        System.out.println("FileChunkInputStream of " + source + " starting at " + offset);
        this.chunkSize = chunkSize;
        raf = new RandomAccessFile(source, "r");
        raf.seek(offset);
    }

    @Override
    public int read() throws IOException {
        if (read >= chunkSize) {
            return -1;
        }
        read++;
        return raf.read();
    }
    
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (read >= chunkSize) {
            return -1;
        }
        read += len;
        if (read >= chunkSize) {
            len -= (int) (read - chunkSize);
        }
        return raf.read(b, off, len);
    }

}
