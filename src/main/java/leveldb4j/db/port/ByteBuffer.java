package leveldb4j.db.port;

public class ByteBuffer implements DBBuffer {
    private static final byte[] EMPTY  = new byte[0];
    private byte[]              bytes  = EMPTY;
    private int                 length = 0;
    private int                 offset = 0;

    public ByteBuffer(int capacity) {
        bytes = new byte[capacity];
    }

    public ByteBuffer(byte[] bytes, int len) {
        this.bytes = bytes;
        length = len;
    }

    public static ByteBuffer wrap(byte[] bytes) {
        return new ByteBuffer(bytes, 0);
    }

    @Override
    public void put(int i, byte b) {
        if (i >= bytes.length)
            throw new IllegalArgumentException();
        bytes[i] = b;

    }

    @Override
    public int get(int i) {
        if (i >= bytes.length)
            throw new IllegalArgumentException();
        return bytes[i];
    }

    @Override
    public byte[] internalBytes() {
        return bytes;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public int capacity() {
        // TODO Auto-generated method stub
        return 0;
    }

}
