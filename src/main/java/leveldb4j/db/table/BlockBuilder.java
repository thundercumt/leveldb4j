package leveldb4j.db.table;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import leveldb4j.db.Slice;
import leveldb4j.db.options.Options;
import leveldb4j.db.port.DBBuffer;
import leveldb4j.db.port.JavaDefs;
import leveldb4j.db.util.Coding;

public class BlockBuilder {
    private Options            options;
    private DBBuffer           buffer;
    private ArrayList<Integer> restarts;
    private int                counter;
    private boolean            finished;
    private String             lastKey;

    public BlockBuilder(Options options) {
    }

    public void reset() {

    }

    public void add(Slice key, Slice value) {

    }

    public Slice finish() {
        for(int i=0; i<restarts.size(); i++) {
            Coding.putFixed32(buffer, restarts.get(i));
        }
    }

    int currentSizeEstimate() {
        return (buffer.capacity() + restarts.size() * JavaDefs.INT_SIZE
                + JavaDefs.INT_SIZE);
    }

    public boolean empty() {
        return buffer.empty();
    }

}
