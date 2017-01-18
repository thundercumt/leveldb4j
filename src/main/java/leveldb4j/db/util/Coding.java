package leveldb4j.db.util;

import java.nio.ByteBuffer;

public class Coding {
    public static int decodeFixed32(ByteBuffer buf, int pos) {
        return ((int) buf.get(pos)) | ((int) buf.get(pos + 1) << 8)
                | ((int) buf.get(pos + 2) << 16)
                | ((int) buf.get(pos + 3) << 24);

    }
}
