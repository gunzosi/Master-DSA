package datastructure.LinkedList.SinglyLinkedList;
import java.util.*;
public class LinkedList<T> {
    public LinkedListNode<T> head;

    // 0. Constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }

    // 1. Create a LinkedList
    public void createLinkedList(T[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode<T> newNode = new LinkedListNode<T>(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

    // The insertNodeAtHead method will insert a LinkedListNode at head of the LinkedList
    public void insertNodeAtHead(LinkedListNode<T> node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    public LinkedListNode<Integer> insertAtTail(LinkedListNode<Integer> head, int value) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(value);

        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode<Integer> current = head;
            // Iterate over the linked list using current
            while(current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        return head;
    }

    public static boolean searchNode(LinkedListNode<Integer> head, int value) {
        LinkedListNode<Integer> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == value) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    // Delete by VALUE

    public static boolean deleteByValue(LinkedListNode<Integer> head, int value) {
        boolean deleted = false;

        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> previous = null;

        if (current.data == value) {
            head = head.next;
            deleted = true;
            return deleted;
        }

        while(current != null) {
            if (value == current.data) {
                previous.next = current.next;
                current.next = null;
                deleted = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        return deleted;
    }
}
