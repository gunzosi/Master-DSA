package codingPattern.InPlaceReversalLinkedList.Helper;

public class LinkedListTraversal {
    static void traverseLinkedList(LinkedListNode head) {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
