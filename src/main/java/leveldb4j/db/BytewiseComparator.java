package leveldb4j.db;

import leveldb4j.error.NotImplementedException;

public class BytewiseComparator implements Comparator {

    @Override
    public int compare(Slice a, Slice b) {
        return a.compareTo(b);
    }

    @Override
    public String name() {
        return "leveldb.BytewiseComparator";
    }

    @Override
    public String findShortestSeparator(String start, Slice limit) {
        throw new NotImplementedException();
    }

    @Override
    public String FindShortSuccessor(String key) {
        throw new NotImplementedException();
    }

}
