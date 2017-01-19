package leveldb4j.db.table;

import java.nio.ByteBuffer;

import leveldb4j.db.Comparator;
import leveldb4j.db.Iterator;
import leveldb4j.db.Slice;
import leveldb4j.db.port.DBBuffer;
import leveldb4j.db.port.JavaDefs;
import leveldb4j.db.util.Coding;
import leveldb4j.error.NotImplementedException;

public class Block {
    private int        size;
    private DBBuffer data;
    int                restartOffset;
    boolean            owned;

    public static class BlockContents {
        public Slice   data;
        public boolean cacheable;

        /**
         * not used, left for completeness
         */
        public boolean heapAllocated;
    }

    public Block(BlockContents contents) {
        data = contents.data.getData();
        size = contents.data.getSize();
        owned = contents.heapAllocated;

        if (size < JavaDefs.INT_SIZE) {
            size = 0; // error marker
        } else {
            int maxRestartsAllowed = (size - JavaDefs.INT_SIZE)
                    / JavaDefs.INT_SIZE;
            if (numRestarts() > maxRestartsAllowed) {
                // the size is too small for numRestarts()
                size = 0;
            } else {
                restartOffset = size - (1 + numRestarts()) * JavaDefs.INT_SIZE;
            }
        }
    }

    public int size() {
        return size;
    }

    public Iterator newIterator(Comparator comparator) {
        throw new NotImplementedException();
    }

    private int numRestarts() {
        return Coding.decodeFixed32(data, size - JavaDefs.INT_SIZE);
    }

}
