package Main;


import BinomialHeap.BinomialHeap;
import HashTable.HashTable;
import RedBlackTree.RedBlackTree;
import RedBlackTree.RedBlackNode;
import SkipLists.Skiplist;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {

        /*HashTable alice = new HashTable("C:\\Users\\djros\\Documents\\OOD\\algo-5800-hw89\\src\\main\\java\\HashTable\\alice.txt");
        alice.listAllKeys();
        alice.listSizes();
        alice.printLongestLists();*/
       // System.out.println(alice.find("alice").key + " " + alice.find("alice").val);


        /*
        //int[] ints = {4, 6, 27, 8, 32, 5, 9, 13, 77, 8};
        RedBlackTree tree = new RedBlackTree("C:\\Users\\djros\\Documents\\OOD\\algo-5800-hw89\\src\\main\\java\\RedBlackTree\\ints.txt");
        tree.sort(tree.root);
        System.out.println();
        tree.print(tree.root);

        System.out.println(tree.search(6).val); // right left left
        System.out.println(tree.predecessor(tree.root.right.left.left).val); //6 predecessor = 4
        System.out.println(tree.successor(tree.root.right.left.left).val); //6 succsessor = 7

        System.out.println(tree.search(0).val); // left right left right
        System.out.println(tree.predecessor(tree.root.left.right.left.right).val); //0 predecessor = -4
        System.out.println(tree.successor(tree.root.left.right.left.right).val); //0 succsessor = 2

        System.out.println(tree.minimum(tree.root).val); // -94
        System.out.println(tree.maximum(tree.root).val); // 81

        tree.delete(tree, tree.root.left.right); // delete 2
        tree.sort(tree.root);

        tree.delete(tree, tree.root); // delete 4
        tree.delete(tree, tree.root); // delete 6
        tree.delete(tree, tree.root); // delete 7
        tree.sort(tree.root);
        */

        RedBlackTree rbt = new RedBlackTree();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter a command: insert x, sort, search x, min, max. Or, type 'exit' to exit");
            String input = "";
            input = bufferedReader.readLine();
            String[] inputs = input.split(" ");
            if (inputs.length == 2) {
                try {
                    if (inputs[0].equals("insert")) {
                        rbt.insert(rbt, new RedBlackNode(Integer.parseInt(inputs[1])));
                    } else if (inputs[0].equals("search")) {
                        rbt.search(Integer.parseInt(inputs[1]));
                    } else {
                        System.out.println("Invalid input\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input\n");
                }
            } else if (inputs.length == 1) {
                if (inputs[0].equals("min")) {
                    System.out.println(rbt.minimum(rbt.root).val);
                } else if (inputs[0].equals("max")) {
                    System.out.println(rbt.maximum(rbt.root).val);
                } else if (inputs[0].equals("sort")) {
                    rbt.sort(rbt.root);
                } else if (inputs[0].equals("exit")) {
                    System.out.println("Goodbye");
                    exit = true;
                } else {
                    System.out.println("Invalid input\n");
                }
            } else {
                System.out.println("Invalid input size\n");
            }

        }

        /*
        Skiplist skiplist = new Skiplist();
        skiplist.insert(10);
        skiplist.insert(20);
        skiplist.insert(40);
        skiplist.insert(80);
        skiplist.insert(30);
        //skiplist.insert(20);
        skiplist.insert(60);
        skiplist.print();
        skiplist.lookup(20);
        skiplist.lookup(30);
        System.out.println();
        skiplist.delete(20);
        skiplist.delete(60);
        skiplist.print();
        skiplist.lookup(20);
        skiplist.lookup(30);
        */




        /*
        BinomialHeap bh = new BinomialHeap();
        bh.insert(bh, 10);
        bh.insert(bh, 2);
        bh.insert(bh, 12);
        bh.insert(bh, 4);
        bh.insert(bh, 18);
        bh.insert(bh, 16);
        bh.insert(bh, 14);
        //bh.insert(bh, 8);
      //  bh.print(bh.lowestOrderTree);
        //bh.extractMinimum();
       // System.out.println(bh.minimum().key);
        //bh.delete(bh.lowestOrderTree.child.sibling); //2
        //bh.print(bh.lowestOrderTree);

        BinomialHeap bh2 = new BinomialHeap();
        bh2.insert(bh2, 5);
        bh2.insert(bh2, 1);
        bh2.insert(bh2, 3);
        bh2.insert(bh2, 11);
        bh2.insert(bh2, 9);
        bh2.insert(bh2, 13);
        bh2.insert(bh2, 7);

        BinomialHeap bUnion = bh.union(bh, bh2);
        //bUnion.print(bUnion.lowestOrderTree);
        bUnion.extractMinimum();
        //System.out.println(bUnion.lowestOrderTree.sibling.sibling.key);
       // bUnion.print(bUnion.lowestOrderTree);
        //bUnion.print(bUnion.reverseSiblings(bUnion.lowestOrderTree.sibling.sibling.child));
        bUnion.decreaseKey(bUnion.lowestOrderTree.sibling.sibling.child, 1); // 9
        bUnion.print(bUnion.lowestOrderTree);
        System.out.println(bUnion.minimum().key); // 1
        bUnion.delete(bUnion.lowestOrderTree.sibling.sibling.child.sibling); // 4
        bUnion.print(bUnion.lowestOrderTree);
        */





    }
}