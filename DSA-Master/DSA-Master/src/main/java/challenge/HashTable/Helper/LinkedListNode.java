package challenge.HashTable.Helper;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;
    // LinkedListNode() will be used to make a LinkedListNode type object.
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}