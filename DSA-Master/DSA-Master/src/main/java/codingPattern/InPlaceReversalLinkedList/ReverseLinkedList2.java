package codingPattern.InPlaceReversalLinkedList;

import codingPattern.InPlaceReversalLinkedList.Helper.LinkedList;
import codingPattern.InPlaceReversalLinkedList.Helper.LinkedListNode;
import codingPattern.InPlaceReversalLinkedList.Helper.PrintList;
import codingPattern.SlidingWindow.Helper.Print;

public class ReverseLinkedList2 {
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        LinkedListNode curr = prev.next;

        for (int i = 0; i < right - left; i++)  {
            LinkedListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3, 4, 5, 6, 7},
                {6, 9, 3, 10, 7, 4, 6},
                {6, 9, 3, 4},
                {6, 2, 3, 6, 9},
                {6, 2}
        };
        int[] left = {1, 3, 2, 1, 1};
        int[] right = {5, 6, 4, 3, 2};
        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tOriginal linked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tLeft: " + left[i] + ", Right: " + right[i] + "\n\n");
            System.out.print("\tReversed linked list:  " );
            PrintList.printListWithForwardArrow(reverseBetween(list.head,left[i],right[i]));
            System.out.println(Print.repeat("-", 100));
        }
    }
}
