package leveldb4j.db;

import leveldb4j.error.NotImplementedException;

/**
 * BloomFilter interface
 *
 */
public interface FilterPolicy {
    String name();

    String createFilter(Slice[] keys);

    boolean keyMayMatch(Slice key, Slice filter);

    public static FilterPolicy newBloomFilterPolicy(int bitsPerKey) {
        throw new NotImplementedException();
    }
}
