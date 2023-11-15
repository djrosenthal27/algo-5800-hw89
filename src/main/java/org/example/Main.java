package org.example;


import HashTable.HashTable;
import RedBlackTree.RedBlackTree;
import SkipLists.Skiplist;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*
        HashTable alice = new HashTable("C:\\Users\\djros\\Documents\\OOD\\algo-5800-hw89\\src\\main\\java\\HashTable\\alice.txt");
        alice.listAllKeys();
        alice.listSizes();
        */

        //int[] ints = {4, 6, 27, 8, 32, 5, 9, 13, 77, 8};
       /* RedBlackTree tree = new RedBlackTree("C:\\Users\\djros\\Documents\\OOD\\algo-5800-hw89\\src\\main\\java\\RedBlackTree\\ints.txt");
        tree.sort(tree.root);
        System.out.println();
        tree.print(tree.root);*/

        Skiplist skiplist = new Skiplist();
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
        skiplist.print();


    }
}