package challenge.DoubyLinkedListP;

public class PalindromeDLL2Pointer {
    public static boolean isPalindrome(DoublyLinkedListNode head) {
        DoublyLinkedListNode start = head;
        DoublyLinkedListNode end = getTailNode(head);

        if (start == null) {
            return true;
        }

        while (start != end && start.prev != end) {
            if (start.data != end.data) {
                return false;
            }

            start = start.next;
            end = end.prev;
        }
        return true;
    }

    private static DoublyLinkedListNode getTailNode(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }


    public static void main(String[] args) {

    }
}
