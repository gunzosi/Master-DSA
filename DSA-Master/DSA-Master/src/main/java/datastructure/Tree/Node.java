package datastructure.Tree;

public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    Node(int value) {
        this.data = value;
        leftChild = null;
        rightChild = null;
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


}
