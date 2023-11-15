package LinkedList;

public class LinkedList<K, V> {
    public LinkedListNode<K, V> nil;

    public LinkedList() {
        this.nil = new LinkedListNode<K, V>(null, null);
        this.nil.next = this.nil;
        this.nil.prev = this.nil;
    }

    public void delete(LinkedListNode<K, V> x) {
        x.next.prev = x.prev;
        x.prev.next = x.next;
    }

    public void insert(LinkedListNode<K, V> x, LinkedListNode<K, V> y) {
        x.next = y.next;
        x.prev = y;
        y.next.prev = x;
        y.next = x;
    }

    public LinkedListNode<K, V> search(LinkedList l, K key) {
        l.nil.key = key;
        LinkedListNode<K, V> x = l.nil.next;
        while (!x.key.equals(key)) {
            x = x.next;
        }
        if (x == l.nil) {
            return null;
        } else {
            return x;
        }
    }

    public int size(LinkedList l) {
        int count = 0;
        LinkedListNode<K, V> x = l.nil.next;
        while (x != l.nil) {
            count++;
            x = x.next;
        }
        return count;
    }
}
