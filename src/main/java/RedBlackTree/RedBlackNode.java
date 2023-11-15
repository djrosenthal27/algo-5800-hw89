package RedBlackTree;

public class RedBlackNode {
    public int val;
    public Color color;
    public RedBlackNode left;
    public RedBlackNode right;
    public RedBlackNode parent;

    public RedBlackNode(int val) {
        this.val = val;
    }

    public RedBlackNode() {
        this.color = Color.BLACK;
        this.left = this;
        this.right = this;
        this.parent = this;
    }

}
