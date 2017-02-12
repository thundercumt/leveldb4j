package leveldb4j.db.table;

import java.util.ArrayList;

import leveldb4j.db.FilterPolicy;
import leveldb4j.db.Slice;
import leveldb4j.error.NotImplementedException;

public class FilterBlockBuilder {
    private static final int   kFilterBaseLg = 11;
    private static final int   kFilterBase   = 1 << kFilterBaseLg;

    private final FilterPolicy policy;
    private String             keys;
    private ArrayList<Integer> start;
    private String             result;
    private ArrayList<Slice>   tmpKeys;
    private ArrayList<Integer> filterOffsets;

    public FilterBlockBuilder(FilterPolicy policy) {
        this.policy = policy;
    }

    public void startBlock(long blockOffset) {
        long filterIndex = blockOffset / kFilterBase;
        assert filterIndex >= filterOffsets.size();
        while (filterIndex > filterOffsets.size()) {
            generateFilter();
        }

    }

    private void generateFilter() {
        final int numKeys = start.size();
        if (numKeys == 0) {
            filterOffsets.add(result.length());
            return;
        }

        start.add(keys.length());
        throw new NotImplementedException();
    }

    public void addKey(Slice key) {

    }

    public Slice finish() {
        throw new NotImplementedException();
    }

}
