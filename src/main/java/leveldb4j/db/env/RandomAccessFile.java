package leveldb4j.db.env;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.StandardOpenOption;

import leveldb4j.db.Slice;
import leveldb4j.error.DBStatusException;

public class RandomAccessFile extends NIOFileAccess {
    public RandomAccessFile(String path) {
        super(path, StandardOpenOption.READ, StandardOpenOption.WRITE);
    }

    public final Slice read(long offset, int n, ByteBuffer scratch) {
        try {
            fileChannel().position(offset);
            int lpos = scratch.position();
            long l = fileChannel().read(new ByteBuffer[] { scratch }, 0, n);
            if (l == -1) {
                l = scratch.position() - lpos;
            }
            return new Slice(scratch, (int) l);
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }
}
