package challenge.HashTable;

import challenge.HashTable.Helper.*;

import java.util.HashSet;

public class RemoveLLDuplicate {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> currentNode = head;
        LinkedListNode<Integer> prevNode = head;

        HashSet<Integer> visitedNodes = new HashSet<>();

        if (head!=null && currentNode.next != null) {
            while (currentNode != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(currentNode.data)) {
                    //deleting the node by updating the pointer of previous node
                    prevNode.next = currentNode.next;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add(currentNode.data);
                    //moving on to next element in the list
                    prevNode = currentNode;
                }
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Integer[][] inputs = {
                {50, 10, 50, 10, 50},
                {-3, -4, 3, -3, -4, -7},
                {20, 20, 20, 20},
                {100, 100},
                {200}
        };

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<>();
            PrintList<Integer> printLinkedList = new PrintList<Integer>();
            inputLinkedList.createLinkedList(inputs[i]);

            System.out.print((i + 1) + ".\tInput linked list: ");
            printLinkedList.printListWithForwardArrow(inputLinkedList.head);

            System.out.print("\n\tLinked list without duplicates: ");
            printLinkedList.printListWithForwardArrow(removeDuplicates(inputLinkedList.head));
            System.out.println("\n"+ new String(new char[100]).replace('\0', '-'));
        }
    }
}
