package practice.LinkedListP;

public class PrintList<T> {
    public void printListWithForwardArrow(LinkedListNode<T> head)
    {
        LinkedListNode<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }


}
