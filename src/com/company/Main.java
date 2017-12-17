package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int[] chars = new int[128];
    static ArrayList<Node> list = new ArrayList<Node>();

    static PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
        public int compare(Node x, Node y) {
            if (x.getFrequency() > y.getFrequency()) return 1;
            if (x.getFrequency() < y.getFrequency()) return -1;
            return 0;
        }
    });

    static void readFile(String filename){
        int letter;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((letter = reader.read()) != -1) {
                chars[letter]++;
            }
            reader.close();
        }
        catch (FileNotFoundException f) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.print("Error reading file ");
        }
    }

    static Node build_Huffman_Tree(){
        Node n1, n2, total = null;

        if(queue.size() == 0)
            return null;

        while(queue.size() > 1) {
            n1 = queue.peek();
            queue.remove(queue.peek());
            n2 = queue.peek();
            queue.remove(queue.peek());
            total = new Node(n1.getFrequency() + n2.getFrequency());
            total.setLeft(n1);
            total.setRight(n2);
            queue.add(total);
        }

        if(total != null) {
            total.setCode("");
        }

        return total;
    }

    static void addCode(Node n) {
        if(n == null)
            return;

        if(n.getLeft() != null && n.getRight() != null)
        {
            n.getLeft().setCode(n.getCode() + "0");
            n.getRight().setCode(n.getCode() + "1");
            addCode(n.getLeft());
            addCode(n.getRight());
        }
        else
        {
            list.add(n);
            System.out.println(n.getLetter()+" "+n.getCode()+" "+Integer.toBinaryString((int)n.getLetter()));
        }
    }

    public static void main(String[] args) {
        String filename = "/home/kareem/IdeaProjects" +
                "/Huffman Compressor and Decompressor/src/com/company/testing";
        readFile(filename);
        for (int i = 0; i < 128; i++) {
            if (chars[i] != 0) {
                char letter = (char) i;
                queue.add(new Node(chars[i], letter));
            }
        }

        Node root = build_Huffman_Tree();
        if (root != null) {
            addCode(root);
        }
    }



}
