package RedBlackTree;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class RedBlackTree {
    public RedBlackNode root;
    RedBlackNode nil;
    int blackHeight;

    public RedBlackTree(String text) {
        this.nil = new RedBlackNode();
        this.root = nil;
        blackHeight = 0;
        try {
            Scanner filereader = new Scanner(Path.of(text));
            while (filereader.hasNextInt()) {
                RedBlackNode x = new RedBlackNode(filereader.nextInt());
                this.insert(this, x);
            }
        } catch (IOException e) {
            System.out.println("Invalid file name.");
        }

    }

    RedBlackNode search(int k) {
        RedBlackNode x = this.root;
        while (x != this.nil && x.val != k) {
            if (k < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    RedBlackNode minimum(RedBlackNode x) {
        while (x != this.nil && x.left != this.nil) {
            x = x.left;
        }
        return x;
    }

    RedBlackNode maximum(RedBlackNode x) {
        while (x != this.nil && x.right != this.nil) {
            x = x.right;
        }
        return x;
    }

    RedBlackNode successor(RedBlackNode x) {
        if (x.right != this.nil) {
            return minimum(x);
        } else {
            RedBlackNode y = x.parent;
            while (y != this.nil && x == y.right) {
                x = y;
                y = y.parent;
            }
            return y;
        }
    }

    RedBlackNode predecessor(RedBlackNode x) {
        if (x.left != this.nil) {
            return maximum(x);
        } else {
            RedBlackNode y = x.parent;
            while (y != this.nil && x == y.left) {
                x = y;
                y = y.parent;
            }
            return y;
        }
    }

    public void sort(RedBlackNode x) {
        if (x != this.nil) {
            this.sort(x.left);
            System.out.printf(x.val + " ");
            this.sort(x.right);
        }
    }

    public void print(RedBlackNode x) {
        if (x != this.nil) {
            String left = String.valueOf(x.left.val);
            String right = String.valueOf(x.right.val);
            if (x.left == this.nil) {
                left = "NIL (Black)";
            }
            if (x.right == this.nil) {
                right = "NIL (Black)";
            }

            System.out.println(x.val + ", Black:" + x.color.equals(Color.BLACK) + ", Left: " + left
                    + ", Right: " + right);
            this.print(x.left);
            this.print(x.right);
        }
    }

    public void delete(RedBlackTree t, RedBlackNode z) {
        if (z.left == this.nil) {
            transplant(t, z, z.right);
        } else if (z.right == this.nil) {
            transplant(t, z, z.left);
        } else {
            RedBlackNode y = minimum(z.right);
            if (y != z.right) {
                transplant(t, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(t, z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    private void transplant(RedBlackTree t, RedBlackNode u, RedBlackNode v) {
        if (u.parent == this.nil) {
            t.root = v;
        } else if (u.parent.left == u) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != this.nil) {
            v.parent = u.parent;
        }
    }

    void leftRotate(RedBlackTree t, RedBlackNode x) {
        RedBlackNode y = x.right;
        x.right = y.left;
        if (y.left != this.nil) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == this.nil) {
            t.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    void rightRotate(RedBlackTree t, RedBlackNode x) {
        RedBlackNode y = x.left;
        x.left = y.right;
        if (y.right != this.nil) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == this.nil) {
            t.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    void insert(RedBlackTree t, RedBlackNode z) {
        RedBlackNode x = t.root;
        RedBlackNode y = t.nil;
        while (x != t.nil) {
            y = x;
            if (z.val < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;

        if (y == t.nil) {
            t.root = z;
        } else if (z.val < y.val) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = t.nil;
        z.right = t.nil;
        z.color = Color.RED;
        fixup(t, z);
    }

    void fixup(RedBlackTree t, RedBlackNode z) {
        while (z.parent.color == Color.RED) {
            if (z.parent == z.parent.parent.left) {
                RedBlackNode y = z.parent.parent.right;
                if (y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(t, z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    rightRotate(t, z.parent.parent);
                }
            } else {
                RedBlackNode y = z.parent.parent.left;
                if (y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(t, z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    leftRotate(t, z.parent.parent);
                }
            }
        }
        t.root.color = Color.BLACK;

        RedBlackNode n = t.root;
        int bh = 0;
        while (n != t.nil) {
            if (n.left.color.equals(Color.BLACK)) {
                bh++;
            }
            n = n.left;
        }
        this.blackHeight = bh;
        System.out.println(blackHeight);
    }
}
