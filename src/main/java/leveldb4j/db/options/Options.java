package leveldb4j.db.options;

import leveldb4j.db.Cache;
import leveldb4j.db.Comparator;
import leveldb4j.db.FilterPolicy;
import leveldb4j.db.env.Env;
import leveldb4j.db.env.Logger;
import leveldb4j.ext.annotations.Default;

public class Options {

    public static enum CompressionType {
        kNoCompression, kSnappyCompression
    }

    public Comparator      COMPARATOR     = null;

    @Default(type = Default.Type.BOOLEAN, value = "false")
    public boolean         CREATE_IF_MISSING;

    @Default(type = Default.Type.BOOLEAN, value = "false")
    public boolean         ERROR_IF_EXISTS;

    @Default(type = Default.Type.BOOLEAN, value = "false")
    public boolean         PARANOID_CHECKS;

    public Env             ENV            = Env.getInstance();

    public Logger          INFO_LOG       = null;

    @Default(type = Default.Type.UNIT, value = "4MB")
    public int             WRITE_BUFFER_SIZE;

    @Default(type = Default.Type.INTEGER, value = "100")
    public int             MAX_OPEN_FILES;

    public Cache           BLOCK_CACHE    = null;

    @Default(type = Default.Type.UNIT, value = "4K")
    public int             BLOCK_SIZE;

    @Default(type = Default.Type.INTEGER, value = "16")
    public int             BLOCK_RESTART_INTERVAL;

    @Default(type = Default.Type.UNIT, value = "2MB")
    public int             WRITE_FILE_SIZE;

    public CompressionType COMPRESSION    = CompressionType.kSnappyCompression;

    @Default(type = Default.Type.BOOLEAN, value = "false")
    public boolean         REUSE_LOGS;

    public FilterPolicy    FILETER_POLICY = null;
}
