package leveldb4j.db.env;

import java.io.IOException;
import java.nio.file.StandardOpenOption;

import leveldb4j.db.Slice;
import leveldb4j.error.DBStatusException;

public class WritableFile extends NIOFileAccess {
    public WritableFile(String path) {
        super(path, StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
    }

    public void append(Slice data) {
        try {
            fileChannel().position(fileChannel().size());
            fileChannel().write(data.data().asNIOByteBuffer());
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public void close() {
        try {
            fileChannel().close();
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    /**
     * not sure what can be done to flush, java does that in the background I
     * think
     */
    public void flush() {
    }

    public void sync() {
        try {
            fileChannel().force(true);
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }
}
