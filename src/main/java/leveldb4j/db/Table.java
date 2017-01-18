package leveldb4j.db;

import leveldb4j.db.options.ReadOptions;

public interface Table {
    Iterator newIterator(ReadOptions options);

    long approximateOffsetOf(Slice key);

    void readMeta(Footer footer);

    void readFilter(Slice filter);
}
