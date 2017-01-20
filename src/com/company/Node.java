package com.company;

public class Node {

    private Object object;

    private Node right;

    private Node left;


    public Node() {
    }

    public Node(Object object) {
        this.object = object;

        this.right = new Node();
        this.left = new Node();
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}
