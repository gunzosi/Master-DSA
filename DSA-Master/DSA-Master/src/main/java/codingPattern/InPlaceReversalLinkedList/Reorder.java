package codingPattern.InPlaceReversalLinkedList;

import codingPattern.InPlaceReversalLinkedList.Helper.LinkedList;
import codingPattern.InPlaceReversalLinkedList.Helper.LinkedListNode;
import codingPattern.InPlaceReversalLinkedList.Helper.PrintList;
import codingPattern.SlidingWindow.Helper.Print;

public class Reorder {

    public static LinkedListNode reorderList(LinkedListNode head)
    {
        if(head == null)
            return head;
        // find the middle of linked list
        // in 1->2->3->4->5->6 find 4
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast!= null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second part of the list
        // convert 1->2->3->4->5->6 into 1->2->3 and 6->5->4
        // reverse the second half in-place
        LinkedListNode prev = null;
        LinkedListNode curr = slow;
        LinkedListNode next = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // merge two sorted linked lists
        // merge 1->2->3 and 6->5->4 into 1->6->2->5->3->4
        LinkedListNode first = head;
        LinkedListNode second = prev;
        LinkedListNode temp = head;

        while(second.next != null)
        {
            temp = temp.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = first.next.next;
        }

        return head;
    }

    // Driver code
    public static void main(String[] args) {
        LinkedList obj1 = new LinkedList();
        int[] inputList = {1, 1, 2, 2, 3, -1, 10, 12};
        obj1.createLinkedList(inputList);
        System.out.print("1.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj1.head);
        reorderList(obj1.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj1.head);
        System.out.println(Print.repeat("-", 100));

        LinkedList obj2 = new LinkedList();
        int[] inputList1 = {10, 20, -22, 21, -12};
        obj2.createLinkedList(inputList1);
        System.out.print("2.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj2.head);
        reorderList(obj2.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj2.head);
        System.out.println(Print.repeat("-", 100));

        LinkedList obj3 = new LinkedList();
        int[] inputList2 = {1, 1, 1};
        obj3.createLinkedList(inputList2);
        System.out.print("3.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj3.head);
        reorderList(obj3.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj3.head);
        System.out.println(Print.repeat("-", 100));

        LinkedList obj4 = new LinkedList();
        int[] inputList3 = {-2, -5, -6, 0, -1, -4};
        obj4.createLinkedList(inputList3);
        System.out.print("4.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj4.head);
        reorderList(obj4.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj4.head);
        System.out.println(Print.repeat("-", 100));

        LinkedList obj5 = new LinkedList();
        int[] inputList4 = {3, 1, 5, 7, -4, -2, -1, -6};
        obj5.createLinkedList(inputList4);
        System.out.print("5.\tOriginal list: ");
        PrintList.printListWithForwardArrow(obj5.head);
        reorderList(obj5.head);
        System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj5.head);
        System.out.println(Print.repeat("-", 100));
    }
}
