package leveldb4j.db;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import leveldb4j.db.SkipList.Node;
import leveldb4j.db.util.Arena;
import leveldb4j.ext.annotations.Core;

@Core
public class SkipList<K extends Comparable<K>, V> {

    private static class Node<K, V> {
        Node<K, V> above;
        Node<K, V> below;
        Node<K, V> next;
        Node<K, V> prev;

        K          key;
        V          value;

        Node(K key, V value) {
            assert key != null;
            this.key = key;
            this.value = value;
        }

    }

    private Random     rand;
    private K          leftInf, rightInf;
    private Node<K, V> topLeft;

    public SkipList(K leftBound, K rightBound) {
        rand = new Random(System.currentTimeMillis());
        leftInf = leftBound;
        rightInf = rightBound;
        topLeft = new Node<K, V>(leftInf, null);
        Node<K, V> topRight = new Node<K, V>(rightInf, null);
        topLeft.next = topRight;
        topRight.prev = topLeft;
    }

    public Node<K, V> skipSearch(K key) {
        Node<K, V> p = topLeft;
        // loop invariant: p is the current candidate node for a given level
        // that is no greater than key and returns p if p.below is null;
        while (p.below != null) {
            p = p.below;
            while (p.next != null && p.next.key.compareTo(key) <= 0) {
                p = p.next;
            }
        }
        return p;
    }

    public Node<K, V> skipInsert(K key, V value) {
        Node<K, V> find = skipSearch(key);
        if (find.key.equals(key)) {
            find.value = value;
            while (find.above != null)
                find = find.above;
            return find;
        }

        Node<K, V> insert = new Node<K, V>(key, value);
        insert.next = find.next;
        find.next.prev = insert;
        insert.prev = find;
        find.next = insert;

    }

}
