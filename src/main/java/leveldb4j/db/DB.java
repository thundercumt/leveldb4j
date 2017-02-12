package leveldb4j.db;

import leveldb4j.db.options.Options;
import leveldb4j.db.options.ReadOptions;
import leveldb4j.db.options.WriteOptions;
import leveldb4j.error.DBStatusException;
import leveldb4j.error.NotImplementedException;

public class DB implements AutoCloseable {

    private DB() {
    }

    public static DB openDB(Options options, String name)
            throws DBStatusException {
        throw new NotImplementedException();
    }

    public static DB destroyDB(String name) throws DBStatusException {
        throw new NotImplementedException();
    }

    public static DB repareDB(String name) throws DBStatusException {
        throw new NotImplementedException();
    }

    @Override
    public void close() throws DBStatusException {
    }

    public void put(WriteOptions options, Slice key, Slice value)
            throws DBStatusException {
        throw new NotImplementedException();
    }

    public void delete(WriteOptions options, Slice key)
            throws DBStatusException {
        throw new NotImplementedException();
    }

    public void write(WriteOptions options, WriteBatch batch)
            throws DBStatusException {
        throw new NotImplementedException();
    }

    public String get(WriteOptions options, Slice key, Slice value)
            throws DBStatusException {
        throw new NotImplementedException();
    }

    public Iterator newIterator(ReadOptions options) throws DBStatusException {
        throw new NotImplementedException();
    }

    public Snapshot getSnapshot() throws DBStatusException {
        throw new NotImplementedException();
    }

    /**
     * should be put into SnapShot maybe
     * 
     * @return
     * @throws DBStatusException
     */
    public Snapshot releaseSnapshot() throws DBStatusException {
        throw new NotImplementedException();
    }

    public String getProperty(Slice property) throws DBStatusException {
        throw new NotImplementedException();
    }

    public long getApproximateSizes(Range range, int n)
            throws DBStatusException {
        throw new NotImplementedException();
    }

    public void compactRange(Slice begin, Slice end) throws DBStatusException {
        throw new NotImplementedException();
    }
}
