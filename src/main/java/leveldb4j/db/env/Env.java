package leveldb4j.db.env;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import leveldb4j.error.DBStatusException;
import leveldb4j.error.NotImplementedException;

/**
 * java runtime env for leveldb
 * 
 * @author liuty
 *
 */
public class Env {
    private static final Env instance      = new Env();
    static volatile Path     tempDirectory = null;
    static {
        try {
            tempDirectory = Files.createTempDirectory("leveldb_temp_"
                    + Long.toString(System.currentTimeMillis()));
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public static Env getInstance() {
        return instance;
    }

    public SequentialFile newSequentialFile(String fname) {
        return new SequentialFile(fname);
    }

    public RandomAccessFile newRandomAccessFile(String fname) {
        return new RandomAccessFile(fname);
    }

    public WritableFile newWritableFile(String fname) {
        return new WritableFile(fname);
    }

    public WritableFile newAppendableFile(String fname) {
        return newWritableFile(fname);
    }

    public boolean fileExists(String fname) {
        try {
            return Files.exists(Paths.get(fname));
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteFile(String fname) {
        try {
            Files.deleteIfExists(Paths.get(fname));
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public void createDir(String dir) {
        try {
            Files.createDirectory(Paths.get(dir));
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public void deleteDir(String dir) {
        try {
            Files.delete(Paths.get(dir));
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public long getFileSize(String dname) {
        try {
            return Files.size(Paths.get(dname));
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public void rename(String src, String dst) {
        try {
            Files.move(Paths.get(src), Paths.get(dst));
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public FileLock lockFile(String fname) {
        try {
            return FileChannel.open(Paths.get(fname), StandardOpenOption.READ)
                    .lock();
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public void unlockFile(FileLock lock) {
        try {
            lock.release();
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

    public void schedule(Runnable r, Object args) {
        throw new NotImplementedException();
    }

    public void startThread(final ParameteredRunnable r, final Object args) {
        Thread t = new Thread(new ParameteredRunnableWrapper(r, args));
        t.start();
    }

    public String getTestDirectory() {
        return tempDirectory.toAbsolutePath().toString();
    }

    public Logger newLogger(String fname) {
        return new Logger(fname);
    }

    public long nowMicros() {
        return System.nanoTime();
    }

}
