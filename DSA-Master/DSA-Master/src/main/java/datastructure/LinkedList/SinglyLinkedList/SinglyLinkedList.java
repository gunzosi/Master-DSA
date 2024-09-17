package datastructure.LinkedList.SinglyLinkedList;

public class SinglyLinkedList<T> {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        // 1. IsEmpty();
        System.out.println(sll.isEmpty());
        // 3. Insert At Head();
        sll.printList();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtHead(i);
            sll.printList();
        }
    }
    public class Node {
        public T data;
        public Node nextNode;
    }

    public Node headNode;
    public int size;

    // -- 0. Constructor
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    // -- 1. IsEmpty method
    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

    // -- 2. Print List
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = headNode;
        System.out.println("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    // -- 3. Insert at Head - insert new data at the start of the Linked List
    public void insertAtHead(T data) {
        // 3.1 - Creating a new Node and assigning it the new Data Value
        Node newNode = new Node();
        newNode.data = data;
        // 3.2 - Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    // -- 4. Insert at End - insert new data at the end of the Linked List
    public void insertAtEnd(T data) {
        if(isEmpty()) {
            insertAtHead(data);
            return;
        }

        // Creating a new Node with Value Data
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        while(last.nextNode != null) {
            last = last.nextNode;
        }

        last.nextNode = newNode;
        size++;
    }

    // -- 5. Insert After - insert new data after a specific node in the Linked List
    public void insertAfter(T data, T previous) {
        Node newNode = new Node();
        newNode.data = data;

        Node currentNode = this.headNode;
        while(currentNode != null && !currentNode.data.equals(previous)) {
            currentNode = currentNode.nextNode;
        }

        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    // -- 6 . Search Node - search for a specific node in the Linked List
    // ----------------------- ITERATIVE APPROACH -----------------------
    public boolean searchNodeIterative(LinkedListNode<Integer> head, int value) {
        LinkedListNode<Integer> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == value) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    // ------------------------ RECURSIVE APPROACH -----------------------
    // ----- 6.a Helper Function
    public boolean searchNodeRecursion(LinkedListNode<Integer> head, int value) {
        LinkedListNode<Integer> current = head;
        return searchRecursive(current, value);
    }

    private static boolean searchRecursive(LinkedListNode<Integer> node, int value) {
        if (node == null) {
            return false;
        }

        if (node.data == value) {
            return true;
        }

        return searchRecursive(node.next, value);
    }


}
