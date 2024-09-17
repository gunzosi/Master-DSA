package datastructure.LinkedList.DoublyLinkedList;

public class DoublyLinkedList<T> {
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public int size;

    // -- 0. Constructor
    public DoublyLinkedList() {
        this.headNode = null;
    }

    // -- 1. IsEmpty method (HELPER METHOD)
    public boolean isEmpty() {
        if (headNode == null)
            return true;
        return false;
    }

    // -- 2. Print List (HELPER METHOD)
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = headNode;
        System.out.println("List : null <- ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    // -- 3. Insert at Head - insert new data at the start of the Linked List
    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }

        // if List is not empty then Link head to the nextElement of the firstElement
        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }

    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }

        Node currentNode = this.headNode;

        if (currentNode.data.equals(data)) {
            deleteAtHead();
            return;
        }

        while(currentNode != null) {
            if (data.equals(currentNode.data)) {
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if (currentNode.nextNode != null) {
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                }
                size--;
            }
            currentNode = currentNode.nextNode;
        }
    }
}
