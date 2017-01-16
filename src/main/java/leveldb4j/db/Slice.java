package leveldb4j.db;

import java.nio.ByteBuffer;

import leveldb4j.error.InvalidArgumentException;
import leveldb4j.error.NotImplementedException;
import leveldb4j.ext.annotations.MayHaveProblem;
import leveldb4j.ext.annotations.PrematureChange;

public class Slice implements Comparable<Slice> {
    private static final ByteBuffer EMPTY = ByteBuffer.allocate(0);
    private ByteBuffer              data;
    private int                     length;

    public Slice() {
        data = EMPTY;
    }

    public Slice(byte[] data) {
        this.data = ByteBuffer.wrap(data);
        this.length = data.length;
    }

    public Slice(String s) {
        byte[] bytes = s.getBytes();
        this.data = ByteBuffer.wrap(bytes);
        this.length = bytes.length;
    }

    public Slice(ByteBuffer bf, int len) {
        this.data = bf;
        this.length = len;
    }

    public byte[] getDataArray() {
        return data.array();
    }
    
    public ByteBuffer getData() {
        return data;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return data != null && data.limit() == data.capacity()
                && data.position() == 0;
    }

    public byte at(int i) {
        assert 0 <= i && i < data.limit();
        return data.get(i);
    }

    public void clear() {
        data = EMPTY;
    }

    /**
     * need to reexamine what needs to be done to remove prefixing n bytes c/c++
     * just steps pointer n bytes ahead, but java has to ensure previous buffer
     * is least modified if the entire ByteBuffer is large enough to use.
     * 
     * @param n
     */
    @MayHaveProblem
    public void removePrefix(int n) {
        assert 1 <= n && n < data.limit();
        throw new NotImplementedException(
                "need to know the actual invoking context to decide its implementation");
    }

    public String toString() {
        return new String(data.toString());
    }

    public boolean equals(Object b) {
        if (b == null)
            return false;
        if (!(b instanceof Slice))
            return false;
        return compareTo((Slice) b) == 0 ? true : false;
    }

    public int compareTo(Slice b) {
        if (data == null || getLength() == 0)
            throw new InvalidArgumentException();
        if (b == null || b.data == null || b.getLength() == 0)
            throw new InvalidArgumentException();
        if (data == b.data)
            return 0;

        int minLen = Math.min(getLength(), b.getLength());
        int v = 0, i = 0;
        while (i < minLen && v == 0) {
            v = at(i) - b.at(i);
        }

        if (v == 0) {
            if (getLength() > minLen)
                v = 1;
            else if (b.getLength() > minLen)
                v = -1;
        }
        return v;
    }

    public boolean startsWith(Slice b) {
        if (data == null || getLength() == 0)
            return false;
        if (b == null || b.data == null || b.getLength() == 0)
            return false;
        if (data == b.data)
            return true;

        if (b.getLength() > getLength())
            return false;

        for (int i = 0; i < b.getLength(); i++) {
            if (at(i) != b.at(i))
                return false;
        }
        return true;
    }
}
