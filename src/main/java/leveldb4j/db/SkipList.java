package leveldb4j.db;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import leveldb4j.db.util.Arena;
import leveldb4j.ext.annotations.Core;

@Core
public class SkipList<K extends Comparable<K>, V> {

    
    private Random     rand;
    private K          leftInf, rightInf;
    private SkipListEntry<K, V> topLeft, topRight;

    public SkipList(K leftBound, K rightBound) {
        rand = new Random(System.currentTimeMillis());
        leftInf = leftBound;
        rightInf = rightBound;
        topLeft = new SkipListEntry<>(leftInf, null);
        topRight = new SkipListEntry<>(rightInf, null);
        topLeft.next = topRight;
        topRight.prev = topLeft;
    }

    public SkipList() {
        rand = new Random(System.currentTimeMillis());
        leftInf = null;
        rightInf = null;
        topLeft = new SkipListEntry.NegativeInfEntry<>();
        topRight = new SkipListEntry.PositiveInfEntry<>();
        topLeft.next = topRight;
        topRight.prev = topLeft;
    }

    public SkipListEntry<K, V> skipSearch(K key) {
        SkipListEntry<K, V> p = topLeft;
        // loop invariant: p is the current candidate node for a given level
        // that is no greater than key and returns p if p.below is null;
        while (p.below != null) {
            p = p.below;
            while (p.next != null && p.next.keyCompare(key) <= 0) {
                p = p.next;
            }
        }
        return p;
    }

    public SkipListEntry<K, V> skipInsert(K key, V value) {
        SkipListEntry<K, V> find = skipSearch(key);
        if (find.keyEquals(key)) {
            find.value = value;
            while (find.above != null)
                find = find.above;
            return find;
        }

        SkipListEntry<K, V> insert = new SkipListEntry<>(key, value);
        insert.next = find.next;
        find.next.prev = insert;
        insert.prev = find;
        find.next = insert;

        find = insert;
        while (rand.nextBoolean()) {
            while (find != null && find.above == null)
                find = find.prev;

            if (find == null) {
                growEndianTower();
                find = topLeft;
            } else {
                find = find.above;
            }

            SkipListEntry<K, V> towerTop = insert.clone();
            insert.above = towerTop;
            towerTop.below = insert;
            towerTop.next = find.next;
            find.next.prev = towerTop;
            find.next = towerTop;
            towerTop.prev = find;

            insert = towerTop;
            find = insert;
        }

        return insert;
    }

    private void growEndianTower() {
        SkipListEntry<K, V> topLeft = this.topLeft.clone();
        SkipListEntry<K, V> topRight = this.topRight.clone();
        topLeft.next = topRight;
        topRight.prev = topLeft;

        this.topLeft.above = topLeft;
        topLeft.below = this.topLeft;
        this.topLeft = topLeft;

        this.topRight.above = topRight;
        topRight.below = this.topRight;
        this.topRight = topRight;
    }

}
