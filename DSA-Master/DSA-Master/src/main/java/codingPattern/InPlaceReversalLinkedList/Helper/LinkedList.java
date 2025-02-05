package codingPattern.InPlaceReversalLinkedList.Helper;

public class LinkedList<T> {
    public LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head != null) {
            node.next = this.head;
        }
        this.head = node;
    }


    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }
}
