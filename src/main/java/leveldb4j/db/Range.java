package leveldb4j.db;

public class Range {
    Slice start;
    Slice limit;

    public Range() {
    }

    public Range(Slice s, Slice l) {
        start = s;
        limit = l;
    }
}
