package leveldb4j.db;

import leveldb4j.error.NotImplementedException;

public abstract class WriteBatchInternal {
    public static int getCount(WriteBatch batch) {
        throw new NotImplementedException();
    }

    public static int setCount(WriteBatch batch, int n) {
        throw new NotImplementedException();
    }

    public static Long getSequence(WriteBatch batch) {
        throw new NotImplementedException();
    }

    public static void setSequence(WriteBatch batch, Long sequence) {
        throw new NotImplementedException();
    }
    
    public static Slice getContents(WriteBatch batch) {
        throw new NotImplementedException();
    }
    
    public static Long getContentsSize(WriteBatch batch) {
        throw new NotImplementedException();
    }

    public static void setContents(WriteBatch batch, Slice sequence) {
        throw new NotImplementedException();
    }
    
    public static void insertInto(WriteBatch batch, MemTable memTable) {
        throw new NotImplementedException();
    }
    
    public static void append(WriteBatch det, WriteBatch src) {
        throw new NotImplementedException();
    }

}
