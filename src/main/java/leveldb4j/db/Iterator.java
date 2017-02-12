package leveldb4j.db;

import leveldb4j.error.DBStatusException;

public interface Iterator {
    boolean isValid() throws DBStatusException;

    void seekToFirst() throws DBStatusException;

    void seekToLast() throws DBStatusException;

    /**
     * the iterated data set has to be ordered before hand.
     * 
     * @param target
     */
    void seek(Slice target) throws DBStatusException;

    void next() throws DBStatusException;

    void prev() throws DBStatusException;

    Slice key() throws DBStatusException;

    Slice value() throws DBStatusException;

    interface CleanUp {
        void clean(Object arg1, Object arg2);
    }

    void setCleanUp(CleanUp clean);
}
