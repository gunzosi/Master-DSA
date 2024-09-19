package practice.LinkedListP;

public class LinkedList<T> {
    public LinkedListNode<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(LinkedListNode<T> node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void createLinkedList(T[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            LinkedListNode<T> newNode = new LinkedListNode<T>(list[i]);
            insertNodeAtHead(newNode);
        }
    }
}
