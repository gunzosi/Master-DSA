package practice.LinkedListP;

public class RemoveDuplicateLinkedList {

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode<Integer> outerNode = head;

        while (outerNode != null) {
            LinkedListNode<Integer> innerNode = outerNode;
            while (innerNode.next != null && innerNode.next != null) {
                if (outerNode.data.equals(innerNode.next.data)) {
                    innerNode.next = innerNode.next.next;
                } else {
                    innerNode = innerNode.next;
                }
            }
            outerNode = outerNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Integer[][] inputs = {
                {30, 20, 30, 10, 50},
                {-7, -7, -22, -1, -5, -5},
                {1, 1, 1},
                {9, -9, 9},
                {1, -2, -2},
        };

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(inputs[i]);

            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList<Integer> printLinkedList = new PrintList<Integer>();
            printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tLinked list after removing duplicates: ");
            printLinkedList.printListWithForwardArrow(removeDuplicates(inputLinkedList.head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
