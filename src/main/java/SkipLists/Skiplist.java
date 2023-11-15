package SkipLists;

import java.util.Random;

public class Skiplist {
    public SkiplistNode header;
    public SkiplistNode sentinel;

    public Skiplist() {
        this.header = new SkiplistNode();
        this.sentinel = new SkiplistNode();
        this.header.nextNodes.add(this.sentinel);
    }

    public void insert(int key) {
        if (lookup(key) == null) {
            int i = this.header.nextNodes.size() - 1;
            SkiplistNode cur = this.header;
            SkiplistNode[] nodes = new SkiplistNode[this.header.nextNodes.size()];
            while (i >= 0) {
                if (cur.nextNodes.get(i).key < key) {
                    cur = cur.nextNodes.get(i);
                } else {
                    nodes[i] = cur;
                    i--;
                }
            }
            int f = 0;
            while ((int) (Math.random() * 2) == 1) {
                f++;
            }
       //     f=0;
            SkiplistNode newNode = new SkiplistNode(key, f);
            for (int x = Math.min(this.header.nextNodes.size() - 1, f); x >= 0; x--) {
     //           System.out.println(nodes[x].nextNodes.get(x).key + "");
   //             System.out.println(newNode.nextNodes.size() + "");
                //newNode.nextNodes.set(0, nodes[x].nextNodes.get(x));
                newNode.nextNodes.add(0, nodes[x].nextNodes.get(x));
                nodes[x].nextNodes.set(x, newNode);
             //   System.out.println(newNode.nextNodes.get(0).key + "");
             //   System.out.println(nodes[x].nextNodes.get(0).key + "");
            }
            while (this.header.nextNodes.size() <= f + 1) {
                this.header.nextNodes.add(newNode);
                newNode.nextNodes.add(this.sentinel);
            }
        }
    }

    public SkiplistNode lookup(int key) {
        SkiplistNode cur = this.header;
        int level = this.header.nextNodes.size() - 1;
        while (level >= 0) {
            if (cur.nextNodes.get(level).key == key) {
                return cur.nextNodes.get(level);
            } else if (cur.nextNodes.get(level).key < key) {
                cur = cur.nextNodes.get(level);
            } else {
                level--;
            }
        }
        return null;
    }

    public void delete(int key) {
        if (lookup(key) != null) {
            int i = this.header.nextNodes.size() - 1;
            SkiplistNode cur = this.header;
            SkiplistNode[] nodes = new SkiplistNode[this.header.nextNodes.size()];
            SkiplistNode toDelete = null;
            while (i >= 0) {
                if (cur.nextNodes.get(i).key < key) {
                    cur = cur.nextNodes.get(i);
                } else if (cur.nextNodes.get(i).key > key) {
                    nodes[i] = cur;
                    i--;
                } else {
                    toDelete = cur.nextNodes.get(i);
                    nodes[i] = cur;
                    i--;
                }
            }
            for (int x = 0; x < toDelete.nextNodes.size(); x++) {
                nodes[x].nextNodes.set(x, toDelete.nextNodes.get(x));
            }
        }
    }

    public void print() {
        for (int level = this.header.nextNodes.size() - 1; level >= 0; level--) {
            SkiplistNode cur = this.header;
            System.out.printf("Level " + level + ": ");
            while (cur.nextNodes.get(level) != this.sentinel) {
                System.out.printf(cur.nextNodes.get(level).key + " ");
                cur = cur.nextNodes.get(level);
            }
            System.out.println();
        }
    }
}
