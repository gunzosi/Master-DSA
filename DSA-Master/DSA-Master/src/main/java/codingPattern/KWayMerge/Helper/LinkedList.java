package codingPattern.KWayMerge.Helper;

import java.util.*;
// Template for the linked list
public class LinkedList {
    public LinkedListNode head;
    // LinkedList() will be used to make a LinkedList type object.
    public LinkedList() {
        this.head = null;
    }
    // insert_node_at_head method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head != null) {
            node.next = this.head;
        }
        this.head = node;
    }
    // create_linked_list method will create the linked list using the
    // given integer array with the help of InsertAtHead method.
    public void createLinkedList(List<Integer> lst) {
        for (int i = lst.size() - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst.get(i));
            insertNodeAtHead(newNode);
        }
    }
}