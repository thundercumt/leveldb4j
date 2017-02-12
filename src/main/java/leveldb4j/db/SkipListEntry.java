package leveldb4j.db;

public class SkipListEntry<K extends Comparable<K>, V> {
    SkipListEntry<K, V> above;
    SkipListEntry<K, V> below;
    SkipListEntry<K, V> next;
    SkipListEntry<K, V> prev;

    K                   key;
    V                   value;

    /**
     * SkipListEntry does not expect null key value, unless used internally
     * 
     * @param key
     * @param value
     */
    SkipListEntry(K key, V value) {
        assert key != null : "key should be non-null";
        this.key = key;
        this.value = value;
    }

    /**
     * this method is only intended to be called by subclasses
     */
    protected SkipListEntry() {
        this.key = null;
        this.value = null;
    }

    boolean keyEquals(SkipListEntry<K, V> n) {
        assert n != null : "invalid parameter";
        if (n instanceof NegativeInfEntry || n instanceof PositiveInfEntry)
            return false;

        return key.equals(n.key);
    }

    boolean keyEquals(K k) {
        return key.equals(k);
    }

    int keyCompare(SkipListEntry<K, V> n) {
        assert n != null : "invalid parameter";

        if (n instanceof NegativeInfEntry)
            return 1;
        if (n instanceof PositiveInfEntry)
            return -1;
        return key.compareTo(n.key);
    }

    int keyCompare(K k) {
        return key.compareTo(k);
    }

    @Override
    protected SkipListEntry<K, V> clone() {
        return new SkipListEntry<>(key, value);
    }

    static final class NegativeInfEntry<K extends Comparable<K>, V>
            extends SkipListEntry<K, V> {
        boolean keyEquals(SkipListEntry<K, V> n) {
            if (n instanceof NegativeInfEntry)
                return true;
            return false;
        }

        boolean keyEquals(K k) {
            return false;
        }

        int keyCompare(SkipListEntry<K, V> n) {
            if (n instanceof NegativeInfEntry)
                return 0;
            return -1;
        }

        int keyCompare(K key) {
            return -1;
        }

        @Override
        protected SkipListEntry<K, V> clone() {
            return new NegativeInfEntry<>();
        }
    }

    static final class PositiveInfEntry<K extends Comparable<K>, V>
            extends SkipListEntry<K, V> {
        boolean keyEquals(SkipListEntry<K, V> n) {
            if (n instanceof PositiveInfEntry)
                return true;
            return false;
        }

        boolean keyEquals(K k) {
            return false;
        }

        int keyCompare(SkipListEntry<K, V> n) {
            if (n instanceof PositiveInfEntry)
                return 0;
            return 1;
        }

        int keyCompare(K key) {
            return 1;
        }

        @Override
        protected SkipListEntry<K, V> clone() {
            return new PositiveInfEntry<>();
        }

    }

}
