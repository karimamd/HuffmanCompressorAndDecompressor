package com.company;

public class Node {
    private int frequency;
    private char letter;
    private Node left;
    private Node right;
    String code;
    public Node() {

    }

    public Node(int frequency, char letter) {
        this.frequency = frequency;
        this.letter = letter;
        this.left = null;
        this.right = null;

    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }



    public Node(int frequency) {
        this.frequency = frequency;

    }

    public  int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {

        this.frequency = frequency;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}


