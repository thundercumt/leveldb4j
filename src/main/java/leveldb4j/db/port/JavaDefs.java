package leveldb4j.db.port;

import java.nio.ByteOrder;

public class JavaDefs {
    public static final int INT_SIZE = Integer.SIZE / Byte.SIZE;
    public static final int LONG_SIZE = Long.SIZE / Byte.SIZE;
    public static final int BYTE_SIZE = Byte.SIZE / Byte.SIZE;
    public static final ByteOrder ENDIAN = ByteOrder.BIG_ENDIAN;
}
