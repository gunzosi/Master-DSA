package datastructure.LinkedList.SinglyLinkedList;

public class PrintList<T> {
    public void printListWithForwardArrow(LinkedListNode<T> head){
        LinkedListNode<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(" -> ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" -> null ");
    }
}
