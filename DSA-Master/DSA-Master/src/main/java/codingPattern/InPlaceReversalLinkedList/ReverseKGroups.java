package codingPattern.InPlaceReversalLinkedList;

import codingPattern.InPlaceReversalLinkedList.Helper.LinkedList;
import codingPattern.InPlaceReversalLinkedList.Helper.LinkedListNode;
import codingPattern.InPlaceReversalLinkedList.Helper.LinkedListReversal;
import codingPattern.InPlaceReversalLinkedList.Helper.PrintList;

public class ReverseKGroups {
    public static void reverseKGroups(LinkedListNode head, int k) {
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode ptr = dummy;

        while (true) {
            System.out.println("\tIdentifying a group of " + k + " nodes:");
            System.out.println("\t\tptr: " + ptr.data);

            // Keep track of the current position
            LinkedListNode tracker = ptr;

            System.out.print("\t\tCurrent group: ");

            // Traverse k nodes to check if there are enough nodes to reverse
            for (int i = 0; i < k; i++) {
                if (tracker == null) {
                    break;
                }
                tracker = tracker.next;
                if (tracker != null) {
                    System.out.print(tracker.data + " ");
                } else {
                    System.out.print("");
                }
            }

            if (tracker == null) {
                System.out.println();
                System.out.println("\t\tThe above group contains less than " + k + " nodes, so we can't reverse it.\n");
                System.out.print("\tFinal state of the linked list: ");
                PrintList.printListWithForwardArrow(dummy.next);
                break;
            }

            System.out.println();
            System.out.println("\t\tThe above group contains " + k + " nodes, so we can reverse it.\n");

            // Reverse the current group of k nodes
            System.out.println("\tReversing the current group of " + k + " nodes:");
            LinkedListNode[] updatedNodes = LinkedListReversal.reverseLinkedList(ptr.next, k);
            LinkedListNode previous = updatedNodes[0];
            LinkedListNode current = updatedNodes[1];

            System.out.print("\t\tReversed group: ");
            PrintList.printListWithForwardArrow(previous);

            // Connect the reversed group to the rest of the linked list
            System.out.println("\n\n\tRe-attaching the reversed group to the rest of the linked list:");
            LinkedListNode lastNodeOfReversedGroup = ptr.next;
            lastNodeOfReversedGroup.next = current;
            ptr.next = previous;
            ptr = lastNodeOfReversedGroup;
            System.out.print("\t\t");
            PrintList.printListWithForwardArrow(dummy.next);

            System.out.println("\n\n");
        }

    }

    public static void main(String[] args) {
        int[] inputList = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        LinkedList inputLinkedList = new LinkedList();
        inputLinkedList.createLinkedList(inputList);

        System.out.print("Linked list: ");
        PrintList.printListWithForwardArrow(inputLinkedList.head);
        System.out.print("\n");
        System.out.println();

        reverseKGroups(inputLinkedList.head, k);
    }
}
