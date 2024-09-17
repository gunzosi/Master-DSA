package datastructure.LinkedList.SinglyLinkedList;

import static datastructure.LinkedList.SinglyLinkedList.LinkedList.searchNode;

public class Solution {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        // --- 1. Insert at Tail of the Linked List
        /*
        Integer[][] input = {
                {1, 2, 3, 4, 5},
                {-1, -2, -3, -4, -6},
                {3, 2, 1},
                {},
                {1, 2},
        };

        int[] values = {4, -5, 2, 0, -98};

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(input[i]);

            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList<Integer> printLinkedList = new PrintList<Integer>();

            printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println("\n\tNew node to be added: "+ values[i]);
            System.out.print("\n\tUpdated linked list: ");

            printLinkedList.printListWithForwardArrow(list.insertAtTail(inputLinkedList.head, values[i]));
            System.out.println("\n" + new String(new char[100]).replace('\0', '-'));
        }*/

        // --- 2. Insert After a Node in the Linked List
        /*SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtHead(i); // inserting value at the tail of the list
        }

        sll.printList();

        System.out.println ("\nInserting 8 after 2");
        sll.insertAfter(8, 2);
        sll.printList();   // calling insert after
        System.out.println ("\nInserting 10 after 3");
        sll.insertAfter (10, 3);   // calling insert after
        sll.printList();*/

        // --- 3. Search Node in the Linked List
        Integer[][] inputs = {
                {10, 20, 30, 40, 50},
                {-1, -2, -3, -4, -5, -6},
                {3, 2, 1},
                {},
                {12}
        };
        int[] value = {50, -7, 3, 55, 12};

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList<Integer> printLinkedList = new PrintList<Integer>();
            printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println("\n\tLength of linked list: " + searchNode(inputLinkedList.head, value[i]));
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }

    }
}
