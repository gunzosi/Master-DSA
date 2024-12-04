package challenge.DoubyLinkedListP;

public class PrintList {
    public void  PrintListWithForwardArrow(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        while (temp != null ){
            System.out.println(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.println(" <-> ");
            }
        }

        System.out.println(" -> NULL ");
    }
}
