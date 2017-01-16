package leveldb4j.db.options;

import leveldb4j.db.Snapshot;
import leveldb4j.ext.annotations.Default;

public class ReadOptions {
    @Default(type = Default.Type.BOOLEAN, value = "false")
    static boolean  VERIFY_CHECKSUMS;

    @Default(type = Default.Type.BOOLEAN, value = "true")
    static boolean  FILL_CACHE;

    static Snapshot SNAPSHOT = null;
}
