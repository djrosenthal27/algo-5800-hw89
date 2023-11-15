package LinkedList;

public class LinkedListNode<K, V> {
    public LinkedListNode prev;
    public LinkedListNode next;
    public K key;
    public V val;

    public LinkedListNode(K key, V val) {
        this.key = key;
        this.val = val;
    }
}
