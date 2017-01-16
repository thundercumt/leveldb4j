package leveldb4j.db.env;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import leveldb4j.error.DBStatusException;

public abstract class NIOFileAccess implements AutoCloseable {
    private FileChannel fc;

    public NIOFileAccess(String path, OpenOption... options) {
        try {
            Path p = Paths.get(path);
            FileChannel.open(p, options);
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public FileChannel fileChannel() {
        return fc;
    }

    @Override
    public void close() {
        try {
            fc.close();
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }
}
