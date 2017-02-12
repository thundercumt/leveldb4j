package leveldb4j.db.env;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import leveldb4j.error.DBStatusException;

public class Logger extends NIOFileAccess {
    private DateTimeFormatter formater = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss");

    public Logger(String fname) {
        super(fname, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public void logV(String format, Object... args) {
        String dateTime = formater.format(LocalDateTime.now());
        String v = String.format(format, args);
        try {
            fileChannel().write(
                    new ByteBuffer[] { ByteBuffer.wrap(dateTime.getBytes()),
                            ByteBuffer.wrap(v.getBytes()) });
        } catch (IOException e) {
            throw DBStatusException.ioError(e.getMessage(), "");
        }
    }

}
