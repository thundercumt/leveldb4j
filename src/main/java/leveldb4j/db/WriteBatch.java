package leveldb4j.db;

public interface WriteBatch {
    
    void put(Slice key, Slice value);
    
    void delete(Slice key);
    
    void clear(Slice key);

}
