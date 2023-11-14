package org.example;


import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        File file = new File("org/example/alice.txt");
        System.out.println(file.exists());
        HashTable alice = new HashTable("C:\\Users\\djros\\Documents\\OOD\\algo-5800-hw89\\src\\main\\java\\org\\example\\alice.txt");
        alice.listAllKeys();
        alice.listSizes();
    }
}