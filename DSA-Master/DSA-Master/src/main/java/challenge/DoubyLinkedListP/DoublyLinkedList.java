package challenge.DoubyLinkedListP;

public class DoublyLinkedList {
    public DoublyLinkedListNode head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(DoublyLinkedListNode node) {
        if (head == null) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head = node;
        }
    }

    public void createLinkedList(int[] list) {
        for (int j : list) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(j);
            insertNodeAtHead(newNode);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        DoublyLinkedListNode temp = head;
        while (temp != null) {
            result.append(temp.data);
            temp = temp.next;
            if (temp != null) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}
