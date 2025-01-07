package datastructure.Tree;

public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;
    private Node parent;
    private int height;
    private boolean isRed;

    // BST Node
/*    Node(int value) {
        this.data = value;
        leftChild = null;
        rightChild = null;
    }*/


// --- AVL Node
/*    Node(int value) {
        this.data = value;
        this.leftChild = null;
        this.rightChild = null;
        this.height = 1;
    }*/

// --- Black-Red Node
    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
        this.isRed = true;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }
}
