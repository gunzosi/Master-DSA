package challenge.HashTable;

import challenge.HashTable.Helper.LinkedListNode;
import challenge.HashTable.Helper.LinkedList;
import challenge.HashTable.Helper.PrintList;

import java.util.HashSet;

public class UnionIntersectLinkedList {

    static LinkedListNode<Integer> union(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        HashSet<Integer> visitedNodes = new HashSet<>();

        LinkedListNode<Integer> result = null;

        while (head1 != null) {
            visitedNodes.add(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            visitedNodes.add(head2.data);
            head2 = head2.next;
        }

        for (int x : visitedNodes) {
            result = insertAtHead(result, x);
        }

        return result;
    }

    static LinkedListNode<Integer> intersection(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        LinkedListNode<Integer> result = null;
        HashSet<Integer> visitedNodes = new HashSet<>();

        while(head1 != null) {
            int value = head1.data;
            if (!visitedNodes.contains(value)) {
                visitedNodes.add(value);
            }
            head1 = head1.next;
        }

        while (head2 != null) {
            if (visitedNodes.contains(head2.data)) {
                result = insertAtHead(result, head2.data);
                visitedNodes.remove(head2.data);
            }
            head2 = head2.next;
        }

        return result;
    }

    static boolean existsInResult(int data, LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    static LinkedListNode<Integer> insertAtHead(LinkedListNode<Integer> head, int data) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
        newNode.next = head;
        return newNode;
    }

    public static void main(String[] args) {
        Integer[][] unionList = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 1, 2, 2, 3, 3, 4, 4, 5},
                {-45, 34, -54, 45, -65, 54},
                {12},
                {0, 1, 2}
        };

        Integer[][] intersectionList = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 1, 2},
                {1, 1, 2, 2, 3, 3, 4, 4, 5},
                {-45, 34, -54, 45, -65, 54},
                {12}
        };

        Integer[][] inputList2 = {
                {7, 8, 9, 10, 11, 12, 13, 14},
                {1, 3, 4, 1},
                {1, 2, 3, 4, 5, 6},
                {3, 2, 1},
                {12}
        };

        for (int i = 0; i < unionList.length; i++) {
            LinkedList<Integer> inputLinkedList1 = new LinkedList<>();
            LinkedList<Integer> inputLinkedList2 = new LinkedList<>();
            PrintList<Integer> printLinkedList = new PrintList<Integer>();

            inputLinkedList1.createLinkedList(unionList[i]);
            inputLinkedList2.createLinkedList(inputList2[i]);

            System.out.print((i + 1) + ".\tInput linked list 1: ");
            printLinkedList.printListWithForwardArrow(inputLinkedList1.head);

            System.out.print("\n\tInput linked list 2: ");
            printLinkedList.printListWithForwardArrow(inputLinkedList2.head);

            System.out.print("\n\n\tUnion: ");
            printLinkedList.printListWithForwardArrow(union(inputLinkedList1.head, inputLinkedList2.head));

            System.out.print("\n\tIntersection: ");
            printLinkedList.printListWithForwardArrow(intersection(inputLinkedList1.head, inputLinkedList2.head));
            System.out.println("\n"+ new String(new char[75]).replace('\0', '-') + "\n");
        }
    }

}
