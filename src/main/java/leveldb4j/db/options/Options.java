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

    static Comparator      COMPARATOR     = null;

    @Default(type = Default.Type.BOOLEAN, value = "false")
    static boolean         CREATE_IF_MISSING;

    @Default(type = Default.Type.BOOLEAN, value = "false")
    static boolean         ERROR_IF_EXISTS;

    @Default(type = Default.Type.BOOLEAN, value = "false")
    static boolean         PARANOID_CHECKS;

    static Env             ENV            = Env.getInstance();

    static Logger          INFO_LOG       = null;

    @Default(type = Default.Type.UNIT, value = "4MB")
    static int             WRITE_BUFFER_SIZE;

    @Default(type = Default.Type.INTEGER, value = "100")
    static int             MAX_OPEN_FILES;

    static Cache           BLOCK_CACHE    = null;

    @Default(type = Default.Type.UNIT, value = "4K")
    static int             BLOCK_SIZE;

    @Default(type = Default.Type.INTEGER, value = "16")
    static int             BLOCK_RESTART_INTERVAL;

    @Default(type = Default.Type.UNIT, value = "2MB")
    static int             WRITE_FILE_SIZE;

    static CompressionType COMPRESSION    = CompressionType.kSnappyCompression;

    @Default(type = Default.Type.BOOLEAN, value = "false")
    static boolean         REUSE_LOGS;

    static FilterPolicy    FILETER_POLICY = null;
}
