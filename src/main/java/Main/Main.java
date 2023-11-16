package Main;


import BinomialHeap.BinomialHeap;
import HashTable.HashTable;
import RedBlackTree.RedBlackTree;
import SkipLists.Skiplist;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
/*
        HashTable alice = new HashTable("C:\\Users\\djros\\Documents\\OOD\\algo-5800-hw89\\src\\main\\java\\HashTable\\alice.txt");
        alice.listAllKeys();
        alice.listSizes();*/
       // System.out.println(alice.find("alice").key + " " + alice.find("alice").val);


        //int[] ints = {4, 6, 27, 8, 32, 5, 9, 13, 77, 8};
       /* RedBlackTree tree = new RedBlackTree("C:\\Users\\djros\\Documents\\OOD\\algo-5800-hw89\\src\\main\\java\\RedBlackTree\\ints.txt");
        tree.sort(tree.root);
        System.out.println();
        tree.print(tree.root);*/

        /*Skiplist skiplist = new Skiplist();
        skiplist.insert(10);
        skiplist.insert(20);
        skiplist.insert(40);
        skiplist.insert(80);
        skiplist.insert(30);
        skiplist.insert(20);
        skiplist.insert(60);
        skiplist.print();
        skiplist.delete(20);
        skiplist.delete(60);
        skiplist.print();*/

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



    }
}