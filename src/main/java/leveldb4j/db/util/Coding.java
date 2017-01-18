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
    
    public static void encodeFixed32(DBBuffer buf,int value)

    public static void putFixed32(DBBuffer buffer, int value) {
        byte[] buf = new byte[JavaDefs.BYTE_SIZE];
        
        
    }
}
