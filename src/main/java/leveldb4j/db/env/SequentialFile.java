package leveldb4j.db.env;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

import leveldb4j.db.Slice;
import leveldb4j.error.DBStatusException;

/**
 * A file abstraction for reading sequentially through a file
 *
 */
public class SequentialFile extends NIOFileAccess {

    public SequentialFile(String path) {
        super(path, StandardOpenOption.READ, StandardOpenOption.WRITE);
    }

    public final Slice read(int n, ByteBuffer scratch) {
        try {
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

    public final void skip(long n) {
        try {
            long p;
            p = fileChannel().position() + n;
            long limit = fileChannel().size();
            p = p > limit ? limit : p;
            fileChannel().position(p);
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }
}
