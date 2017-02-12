package leveldb4j.db;

import leveldb4j.error.NotImplementedException;

public abstract class Cache {
    
    private interface CacheItemDeleter {
        void delete(Slice key, Object value);
    }
    
    private static class CacheItem {
        Slice key;
        Object value;
        CacheItemDeleter deleter;
        
        CacheItem next;
        CacheItem prev;
        
        int charge;
        int keyLength;
        
        boolean inCache;
        
        int refs;
        int hash;
        char keyHead;
        
        public Slice key() {
            throw new NotImplementedException();
        }
    }
}
