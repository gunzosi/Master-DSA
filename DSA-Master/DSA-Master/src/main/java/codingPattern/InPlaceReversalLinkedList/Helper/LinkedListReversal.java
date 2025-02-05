package codingPattern.InPlaceReversalLinkedList.Helper;

public class LinkedListReversal {
    public static LinkedListNode[] reverseLinkedList(LinkedListNode node, int k) {
        LinkedListNode previous = null;
        LinkedListNode current = node;
        LinkedListNode next = null;

        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        System.out.println("\t\tPointers after reversing k = " + k + " elements:");
        System.out.println("\t\t\tcurrent: " + (current != null ? Integer.toString(current.data) : "null"));
        System.out.println("\t\t\tnext: " + (next != null ? Integer.toString(next.data) : "null"));
        System.out.println("\t\t\tprevious: " + (previous != null ? Integer.toString(previous.data) : "null"));

        return new LinkedListNode[]{previous, current};
    }
}
