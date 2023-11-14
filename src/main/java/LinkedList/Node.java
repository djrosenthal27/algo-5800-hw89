package LinkedList;

public class Node<K, V> {
    public Node prev;
    public Node next;
    public K key;
    public V val;

    public Node(K key, V val) {
        this.key = key;
        this.val = val;
    }
}
