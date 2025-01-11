package challenge.HashTable.Helper;

import java.util.*;
// Template for the linked list
public class LinkedList<T> {
    public LinkedListNode<T> head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // The insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode<T> node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // The createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(T[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode<T> newNode = new LinkedListNode<T>(lst[i]);
            insertNodeAtHead(newNode);
        }
    }
}