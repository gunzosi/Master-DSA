package codingPattern.FastAndSlowPointer.Helper;

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

    public static LinkedListNode getNode(LinkedListNode head, int pos) {
        LinkedListNode ptr = head;

        if (pos != -1) {
            int p = 0;

            while (p < pos) {
                ptr = ptr.next;
                p += 1;
            }

            return ptr;
        }

        return ptr;
    }

    public static int getLength(LinkedListNode head) {
        LinkedListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
