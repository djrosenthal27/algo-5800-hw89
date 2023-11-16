package BinomialHeap;

public class BinomialHeap {
    public BinomialTree lowestOrderTree;

    public BinomialHeap() {
        this.lowestOrderTree = null;
    }

    public void insert(BinomialHeap h, int key) {
        BinomialHeap x = new BinomialHeap();
        x.lowestOrderTree = new BinomialTree(key);
        x.lowestOrderTree.parent = null;
        x.lowestOrderTree.child = null;
        x.lowestOrderTree.sibling = null;
        x.lowestOrderTree.order = 0;
        h.lowestOrderTree = union(h, x).lowestOrderTree;
    }

    public BinomialTree minimum() {
        BinomialTree min = null;
        BinomialTree cur;
        if (this.lowestOrderTree != null) {
            min = this.lowestOrderTree;
            cur = this.lowestOrderTree;
            while (cur.sibling != null) {
                if (cur.sibling.key < min.key) {
                    min = cur.sibling;
                }
                cur = cur.sibling;
            }
        }
        return min;
    }

    public BinomialTree extractMinimum() {
        BinomialTree min = minimum();
        BinomialTree prevMin = this.lowestOrderTree;
        while (prevMin != null) {
            if (prevMin.sibling == min) {
                break;
            } else {
                prevMin = prevMin.sibling;
            }
        }
        if (prevMin == this.lowestOrderTree) {
            this.lowestOrderTree = prevMin.sibling;
        } else if (prevMin == null) {
            return null;
        } else if (prevMin.sibling != null) {
            prevMin.sibling = prevMin.sibling.sibling;
        }
        BinomialTree minChild = min.child;
        while (minChild != null) {
            minChild.parent = null;
            minChild = minChild.sibling;
        }
        BinomialHeap h = new BinomialHeap();
        h.lowestOrderTree = reverseSiblings(min.child);
        this.lowestOrderTree = union(this, h).lowestOrderTree;
        return min;
    }

    public BinomialTree reverseSiblings(BinomialTree t) {
        BinomialTree tCur = t;
        BinomialTree tPrev = null;
        while (tCur != null) {
            BinomialTree tNext = tCur.sibling;
            tCur.sibling = tPrev;
            tPrev = tCur;
            tCur = tNext;
        }
        return tPrev;
    }

    public BinomialHeap union(BinomialHeap p, BinomialHeap q) {
        BinomialHeap newHeap = new BinomialHeap();
        newHeap.lowestOrderTree = merge(p, q);
        if (newHeap.lowestOrderTree == null) {
            return newHeap;
        }
        BinomialTree prevX = null;
        BinomialTree x = newHeap.lowestOrderTree;
        BinomialTree nextX = x.sibling;
        while (nextX != null) {
            if (x.order != nextX.order
                    || (nextX.sibling != null && nextX.sibling.order == x.order)) {
                prevX = x;
                x = nextX;
            } else if (x.key <= nextX.key) {
                x.sibling = nextX.sibling;
                x.mergeTrees(nextX, x);
            } else if (prevX == null) {
                newHeap.lowestOrderTree = nextX;
                x.mergeTrees(x, nextX);
                x = nextX;
            } else {
                prevX.sibling = nextX;
                x.mergeTrees(x, nextX);
                x = nextX;
            }
            nextX = x.sibling;
        }
        return newHeap;
    }

    private BinomialTree merge(BinomialHeap p, BinomialHeap q) {
        BinomialTree newTree = null;
        BinomialTree pCur = p.lowestOrderTree;
        BinomialTree qCur = q.lowestOrderTree;
        BinomialTree newTreeCur = null;
        while (pCur != null && qCur != null) {
            if (pCur.order <= qCur.order) {
                if (newTree == null) {
                    newTree = pCur;
                    newTreeCur = newTree;
                } else {
                    newTreeCur.sibling = pCur;
                    newTreeCur = newTreeCur.sibling;
                }
                pCur = pCur.sibling;
            } else {
                if (newTree == null) {
                    newTree = qCur;
                    newTreeCur = newTree;
                } else {
                    newTreeCur.sibling = qCur;
                    newTreeCur = newTreeCur.sibling;
                }
                qCur = qCur.sibling;
            }
        }
        if (pCur == null) {
            if (qCur != null) {
                if (newTreeCur != null) {
                    newTreeCur.sibling = qCur;
                } else {
                    newTree = qCur;
                }
            }
        } else {
            if (newTreeCur != null) {
                newTreeCur.sibling = pCur;
            } else {
                newTree = pCur;
            }
        }
        return newTree;
    }

    public void decreaseKey(BinomialTree p, int newKey) throws IllegalAccessException {
        if (p.key < newKey) {
            throw new IllegalAccessException("New key can't be greater than old key");
        }
        p.key = newKey;
        BinomialTree q = p;
        BinomialTree r = q.parent;
        while (r != null && q.key < r.key) {
            int temp = q.key;
            q.key = r.key;
            r.key = temp;
          /*  BinomialTree qSib = q.sibling;
            q.sibling = r.sibling;
            r.sibling = qSib;
            BinomialTree rPar = r.parent;
            r.parent = q;
            if (q.child != null) {
                q.child.parent = r;
            }
            r.child = q.child;
            q.child = r;
            q.parent = rPar;
            if (rPar != null) {
                rPar.child = q;
            }
            q = r;
            r = q.parent;*/
        }
    }

    public void delete(BinomialTree p) throws IllegalAccessException {
        decreaseKey(p, Integer.MIN_VALUE);
        extractMinimum();
    }

    public void print(BinomialTree t) {
        if (t != null) {
            String sib = "null";
            String child = "null";
            String par = "null";
            if (t.sibling != null) {
                sib = String.valueOf(t.sibling.key);
            }
            if (t.child != null) {
                child = String.valueOf(t.child.key);
            }
            if (t.parent != null) {
                par = String.valueOf(t.parent.key);
            }
            System.out.println("Key:" + t.key + ",Sib:" + sib + ",Child:" + child+ ",Parent:" + par);
            print(t.child);
            print(t.sibling);
        }
    }

}
