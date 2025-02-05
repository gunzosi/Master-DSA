package codingPattern.InPlaceReversalLinkedList;

import codingPattern.InPlaceReversalLinkedList.Helper.LinkedList;
import codingPattern.InPlaceReversalLinkedList.Helper.LinkedListNode;
import codingPattern.InPlaceReversalLinkedList.Helper.PrintList;

import java.util.*;

class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {
        // initialize prev and next pointer to NULL
        LinkedListNode prev = null;
        LinkedListNode next = null;
        // set current pointer to the head node
        LinkedListNode curr = head;
        // while the current pointer is not NULL
        while (curr != null) {
            // set the next pointer to the next node in the list
            next = curr.next;
            // reverse the current node's pointer to point to the previous node
            curr.next = prev;
            // set the previous pointer to the current node
            prev = curr;
            // move the current pointer to the next node
            curr = next;
        }
        // set the head pointer to the last node, which is the new first node after reversal
        head = prev;
        // return the new head pointer
        return head;
    }

    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {3, 2, 1},
                {10},
                {1, 2}
        };

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tReversed linked list: ");
            PrintList.printListWithForwardArrow(reverse(inputLinkedList.head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}