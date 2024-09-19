package practice.LinkedListP;



public class MiddleOfLinkedList {

    public static LinkedListNode<Integer> findMiddle(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> mid = head;
        LinkedListNode<Integer> fast = head;

        while (fast != null && fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        return mid;
    }

    private static int length(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> curr = head;
        int length = 0;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    public static void main(String[] args) {

        Integer[][] input = {
                {7, 10, 14, 21, 22},
                {3, 6, 9, 12},
                {23, 19, 15, 22, 34, 76, 12},
                {5},
                {1, 3, 5, 7, 9, 11,6},
        };

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList<Integer> printLinkedList = new PrintList<Integer>();
            printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tMiddle Node: " + findMiddle(inputLinkedList.head).data);
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
