package challenge.LinkedListP;

public class LengthOfLinkedList {

    public static int length(LinkedListNode<Integer> head) {
        int count = 0;
        LinkedListNode<Integer> current = head;
        while (current != null ) {
            count++;
            current = current.next;
        }
        return count;
    }


    public static void main(String args[]) {
        Integer[][] input = {
                {10, 20, 30, 40, 50},
                {-1, -2, -3, -4, -5, -6},
                {3, 2, 1},
                {},
                {12},
        };

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList<Integer> printLinkedList = new PrintList<Integer>();
            printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println("\n\tLength of linked list: "+ length(inputLinkedList.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
