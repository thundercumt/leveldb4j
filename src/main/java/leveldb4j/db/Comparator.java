package leveldb4j.db;

/**
 * Concurrent thread-safe comparator
 *
 */
public interface Comparator {

    int compare(Slice a, Slice b);

    String name();

    /**
     * Advanced functions: these are used to reduce the space requirements for
     * internal data structures like index blocks.
     * 
     * If *start < limit, changes *start to a short string in [start,limit).
     * Simple comparator implementations may return with *start unchanged, i.e.,
     * an implementation of this method that does nothing is correct.
     * 
     * @param start
     * @param limit
     */
    String findShortestSeparator(String start, Slice limit);

    /**
     * Changes *key to a short string >= *key. Simple comparator implementations
     * may return with *key unchanged, i.e., an implementation of this method
     * that does nothing is correct.
     * 
     * @param key
     * @return
     */
    String FindShortSuccessor(String key);

    public static Comparator byteWiseComparator() {
        return new BytewiseComparator();

    }
}
