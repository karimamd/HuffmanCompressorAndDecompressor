package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*public class Comparator{

}*/

public class Main {
    static ArrayList<Node> list=new ArrayList<Node>();

    static void addCode(Node n) {

        if(n.getLeft()!=null && n.getRight()!=null)
        {
            n.getLeft().code=n.code+"0";
            n.getRight().code=n.code+"1";
            addCode(n.getLeft());
            addCode(n.getRight());

        }
        else
        {
            list.add(n);

            System.out.println(n.getLetter()+" "+n.code+" "+Integer.toBinaryString((int)n.getLetter()));
        }


    }


    static Node build_Huffman_Tree(PriorityQueue<Node> pQueue){
        if(pQueue.size() == 0)
            return null;
        Node n1,n2,nTotal;
        nTotal=null;
        while(pQueue.size() > 1){
            n1=pQueue.peek();
            pQueue.remove(pQueue.peek());
            n2=pQueue.peek();
            pQueue.remove(pQueue.peek());
             nTotal= new Node(n1.getFrequency()+n2.getFrequency());
            nTotal.setLeft(n1);
            nTotal.setRight(n2);
            pQueue.add(nTotal);
        }
        nTotal.code="";
        return nTotal;

    }




    static ArrayList<Node> availableChars = new ArrayList<Node>();
    static PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
        public int compare(Node x, Node y) {
            if (x.getFrequency() > y.getFrequency()) return 1;
            if (x.getFrequency() < y.getFrequency()) return -1;
            return 0;
        }
    });
    static int[] chars = new int[128];

    public static void main(String[] args) {
        // write your code here
        int c;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/kareem/IdeaProjects" +
                    "/Huffman Compressor and Decompressor/src/com/company/testing"));

            while ((c = reader.read()) != -1) {

                char letter = (char) c;
                chars[c]++;

            }
            reader.close();

        } catch (IOException e) {
            System.out.print("error reading file ");
        }
        for (int i = 0; i < 128; i++) {

            if (chars[i] != 0) {
                char lett = (char) i;
                //System.out.println(lett + " " + chars[i]);
                ////availableChars.add( new Node(chars[i],lett) );
                queue.add(new Node(chars[i], lett));


            }
        }

        Node root=build_Huffman_Tree(queue);
        addCode(root);

    }



}
