package leveldb4j.db.table;

import java.util.ArrayList;

import leveldb4j.db.FilterPolicy;
import leveldb4j.db.Slice;

public class FilterBlockBuilder {
    private final FilterPolicy policy;
    private String keys;
    private ArrayList<Integer> start;
    private String result;
    private ArrayList<Slice> tmpKeys;
    private ArrayList<Integer> filterOffsets;
    
    
    public FilterBlockBuilder(FilterPolicy policy) {
        this.policy = policy;
    }
    
    public void startBlock(long blockOffset) {
        
    }
    
    public void addKey(Slice key) {
        
    }
    
    public Slice finish() {
        
    }

}
