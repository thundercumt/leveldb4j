package leveldb4j.db.util;

import java.nio.ByteBuffer;

import leveldb4j.db.port.DBBuffer;
import leveldb4j.db.port.JavaDefs;

public class Coding {
    public static int decodeFixed32(DBBuffer buf, int pos) {
        return ((int) buf.get(pos)) | ((int) buf.get(pos + 1) << 8)
                | ((int) buf.get(pos + 2) << 16)
                | ((int) buf.get(pos + 3) << 24);

    }

    public static void encodeFixed32(DBBuffer buf, int pos, int value) {
        buf.put(pos, (byte) (value & 0xff));
        buf.put(pos + 1, (byte) ((value >> 8) & 0xff));
        buf.put(pos + 2, (byte) ((value >> 16) & 0xff));
        buf.put(pos + 3, (byte) ((value >> 24) & 0xff));
    }
    
    public static void encodeVarInt32(DBBuffer buf, int pos, int value) {
        throw new IOException();
    }

    public static void putFixed32(DBBuffer buffer, int value) {
        encodeFixed32(buffer, buffer.length(), value);
    }
    
    public static void putVarInt32(DBBuffer buffer, int value) {
        
    }
}
