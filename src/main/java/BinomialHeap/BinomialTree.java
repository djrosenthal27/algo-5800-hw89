package BinomialHeap;

public class BinomialTree {
    public int key;
    public BinomialTree child;
    public BinomialTree sibling;
    public BinomialTree parent;
    public int order;

    public BinomialTree(int key) {
        this.key = key;
        this.child = null;
        this.sibling = null;
        this.parent = null;
        this.order = 0;
    }

    //public BinomialTree(int key) {
       // this(new BinomialNode(key));
    //}

    public void mergeTrees(BinomialTree p, BinomialTree q) {
        p.parent = q;
        p.sibling = q.child;
        q.child = p;
        q.order = p.order + 1;
    }

}
