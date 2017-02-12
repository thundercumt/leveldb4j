package leveldb4j.db.util;

import leveldb4j.db.port.DBBuffer;

public class Coding {
    public static int decodeFixed32(DBBuffer buf, int pos) {
        return ((int) buf.get(pos)) | ((int) buf.get(pos + 1) << 8) | ((int) buf.get(pos + 2) << 16)
                | ((int) buf.get(pos + 3) << 24);

    }

    public static void encodeFixed32(DBBuffer buf, int pos, int value) {
        buf.put(pos, (byte) (value & 0xff));
        buf.put(pos + 1, (byte) ((value >> 8) & 0xff));
        buf.put(pos + 2, (byte) ((value >> 16) & 0xff));
        buf.put(pos + 3, (byte) ((value >> 24) & 0xff));
    }

    public static int encodeVarInt32(DBBuffer buf, int pos, int v) {
        final int B = 128;
        int idx = pos;
        if (v < (1 << 7)) {
            buf.put(idx++, (byte) v);
        } else if (v < (1 << 14)) {
            buf.put(idx++, (byte) (v | B));
            buf.put(idx++, (byte) (v >> 7));
        } else if (v < (1 << 21)) {
            buf.put(idx++, (byte) (v | B));
            buf.put(idx++, (byte) ((v >> 7) | B));
            buf.put(idx++, (byte) (v >> 14));
        } else if (v < (1 << 28)) {
            buf.put(idx++, (byte) (v | B));
            buf.put(idx++, (byte) ((v >> 7) | B));
            buf.put(idx++, (byte) ((v >> 14) | B));
            buf.put(idx++, (byte) (v >> 21));

        } else {
            buf.put(idx++, (byte) (v | B));
            buf.put(idx++, (byte) ((v >> 7) | B));
            buf.put(idx++, (byte) ((v >> 14) | B));
            buf.put(idx++, (byte) ((v >> 21) | B));
            buf.put(idx++, (byte) (v >> 28));
        }
        return idx;
    }

    public static void putFixed32(DBBuffer buffer, int value) {
        encodeFixed32(buffer, buffer.length(), value);
    }

    public static void putVarInt32(DBBuffer buffer, int value) {
        encodeVarInt32(buffer, buffer.length(), value);
    }
}
