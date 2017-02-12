package leveldb4j.db.options;

import leveldb4j.ext.annotations.Default;

public class WriteOptions {
    @Default(type = Default.Type.BOOLEAN, value = "true")
    static boolean SYNC;
}
