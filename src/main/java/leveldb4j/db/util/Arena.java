package leveldb4j.db.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Arena {
    private static final int  kBlockSize = 4096;

    private AtomicInteger     memoryUsage;
    private ArrayList<byte[]> blocks;

    public byte[] allocate(int size) {
        assert size > 0;
        memoryUsage.getAndAdd(size);
        byte[] alloc = new byte[size];
        blocks.add(alloc);
        return alloc;
    }

    public byte[] allocateAligned(int size) {
        return allocate(size);
    }

    public int memoryUsage() {
        return memoryUsage.get();
    }
}
