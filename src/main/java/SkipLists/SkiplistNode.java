package SkipLists;

import LinkedList.LinkedListNode;

import java.util.ArrayList;

public class SkiplistNode {
    public ArrayList<SkiplistNode> nextNodes;
    public int key;

    public SkiplistNode() {
        this.key = Integer.MAX_VALUE;
        this.nextNodes = new ArrayList<>();
    }

    public SkiplistNode(int key, int levels) {
        this.key = key;
        this.nextNodes = new ArrayList<>(levels + 1);
    }
}
