package HashTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HashTable {
    LinkedList[] vals;

    private static final int MAXHASH = 30;

    public HashTable(String text) {
        vals = new LinkedList[MAXHASH];
        for (int i = 0; i < MAXHASH; i++) {
            vals[i] = new LinkedList<String, Integer>();
        }

        try {
           // FileInputStream textfile = new FileInputStream(text);
            Scanner filereader = new Scanner(Path.of(text));
            int wordCount = 0;
            while (filereader.hasNext()) {
                String word = removeSpecialChars(filereader.next().toLowerCase());
                if (!word.isEmpty()) {
                    if (find(word) == null) {
                        insert(word, 1);
                        wordCount++;
                    } else {
                        increase(word);
                    }
                }
            }
            //System.out.println(wordCount);
        } catch (IOException e) {
            System.out.println("Invalid file name");
            File textfile = new File(text);
            System.out.println(textfile.exists());
            //throw new RuntimeException(e);
        }


    }

    // Removes all special characters at the beginning and end of a string, keeping
    // dashes and apostrophes for contraction words.
    private static String removeSpecialChars(String word) {
        String newWord = word;
        while (newWord.length() > 0 && (newWord.toCharArray()[0] < 97 || newWord.toCharArray()[0] > 122)) {
            newWord = newWord.substring(1);
        }
        while (newWord.length() > 0 && (newWord.toCharArray()[newWord.length() - 1] < 97
                || newWord.toCharArray()[newWord.length() - 1] > 122)) {
            newWord = newWord.substring(0, newWord.length() - 1);
        }
        return newWord;
    }

    int hashFunction(String key) {
        byte[] bytes =  key.getBytes(StandardCharsets.UTF_8);
        int x = 0;
        for (byte b : bytes) {
            x+=(b*b);
        }
        return ((97 * x + 419) % 7919) % MAXHASH;
       // return 1;
        //return (int) (MAXHASH * ((x * Math.PI) % 1));
    }

    int hashFunction2(String key) {
        byte[] bytes =  key.getBytes(StandardCharsets.UTF_8);
        int x = 0;
        for (byte b : bytes) {
            x+=(Math.max((b-96)*(b-96)*(b-96), 0));
        }
        return x;
        // return 1;
        //return (int) (MAXHASH * ((x * Math.PI) % 1));
    }

    public LinkedListNode<String, Integer> find(String key) {
        return vals[hashFunction(key)].search(vals[hashFunction(key)], key);
    }
    void insert(String key, int val) {
        //Node<String, Integer> x = find(key);
       // if (x == null) {
            vals[hashFunction(key)].insert(new LinkedListNode<>(key, val), vals[hashFunction(key)].nil);
       // }
    }

    void delete(String key) {
        LinkedListNode<String, Integer> x = find(key);
        if (x != null) {
            vals[hashFunction(key)].delete(x);
        }
    }

    void increase(String key) {
        LinkedListNode<String, Integer> x = find(key);
        if (x != null) {
            x.val++;
        }
    }

    public void listAllKeys() {
        try {
            File output = new File("C:\\Users\\djros\\Documents\\OOD\\algo-5800-hw89\\src\\main\\java\\HashTable\\wordcountOutput.txt");
            FileWriter fw = new FileWriter(output);
            for (LinkedList<String, Integer> list : vals) {
                LinkedListNode<String, Integer> cur = list.nil.next;
                while (cur != list.nil) {
                    fw.write(cur.key + ": " + cur.val + "\n");
                    //System.out.println(cur.key + ": " + cur.val);
                    //System.out.println(hashFunction2(cur.key));
                    cur = cur.next;
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Output file error");
        }
    }

    public void listSizes() {
        System.out.println("List sizes:");
        for (LinkedList<String, Integer> list : vals) {
            System.out.println(list.size(list));
        }
    }

    public void printLongestLists() {
        ArrayList<Integer> largestLists = new ArrayList<>();
        for (LinkedList<String, Integer> list : vals) {
            largestLists.add(list.size(list));
        }
        Collections.sort(largestLists);
        for (int i = 0; i < (MAXHASH - MAXHASH/10); i++) {
            largestLists.remove(0);
        }
        System.out.println("Largest 10% of lists: ");
        for (int size : largestLists) {
            System.out.println(size);
        }
    }



}
