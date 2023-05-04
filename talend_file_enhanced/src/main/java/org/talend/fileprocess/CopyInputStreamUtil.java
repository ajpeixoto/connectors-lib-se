package org.talend.fileprocess;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyInputStreamUtil {

    private InputStream _is;

    private ByteArrayOutputStream _copy = new ByteArrayOutputStream();

    /**
     * 
     */
    public CopyInputStreamUtil(InputStream is) {
        _is = is;

        try {
            copy();
        } catch (IOException ex) {
            // do nothing
        }
    }

    private int copy() throws IOException {
        int read = 0;
        int chunk = 0;
        byte[] data = new byte[256];

        while (-1 != (chunk = _is.read(data))) {
            read += data.length;
            _copy.write(data, 0, chunk);
        }

        return read;
    }

    public InputStream getCopy() {
        return new ByteArrayInputStream(_copy.toByteArray());
    }
}
