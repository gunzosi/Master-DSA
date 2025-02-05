package codingPattern.InPlaceReversalLinkedList;

import codingPattern.InPlaceReversalLinkedList.Helper.LinkedList;
import codingPattern.InPlaceReversalLinkedList.Helper.LinkedListNode;
import codingPattern.InPlaceReversalLinkedList.Helper.PrintList;

public class SwapNodes {
    public static void swap(LinkedListNode node1, LinkedListNode node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public static LinkedListNode swapNodes(LinkedListNode head, int k) {
        if (head == null) {
            return head;
        }

        // Find the length of the linked list and the kth node from beginning
        LinkedListNode curr = head;
        LinkedListNode front = null;
        int count = 0;

        // Find kth node from beginning
        while (curr != null) {
            count++;
            if (count == k) {
                front = curr;
            }
            curr = curr.next;
        }

        // Find kth node from end using length
        LinkedListNode end = head;
        for (int i = 1; i < count - k + 1; i++) {
            end = end.next;
        }

        // Swap the values
        swap(front, end);
        return head;
    }


    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5, 6, 7},
                {6, 9, 3, 10, 7, 4, 6},
                {6, 9, 3, 4},
                {6, 2, 3, 6, 9},
                {6, 2}
        };
        int[] k = {
                2, 3, 2, 3, 1
        };

        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tOriginal linked list is: ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.println("\tk: "+k[i]);
            System.out.print("\tLinked list with swapped values: ");
            PrintList.printListWithForwardArrow(swapNodes(list.head,k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
