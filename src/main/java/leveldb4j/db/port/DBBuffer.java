package leveldb4j.db.port;

public interface DBBuffer {
    public void put(int i, byte b);

    public int get(int i);

    public byte[] internalBytes();

    public int length();

    public int capacity();
    
    public boolean empty();

    public void append(byte[] values);
}
