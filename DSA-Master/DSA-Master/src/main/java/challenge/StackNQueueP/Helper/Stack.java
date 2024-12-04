package challenge.StackNQueueP.Helper;

public class Stack <V>{
    private int maxSize;
    private int top;
    private V[] array;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1;
        array = (V[]) new Object[max_size];
        this.currentSize = 0;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public V top() {
        if (isEmpty())
            return null;
        return array[top];
    }

    public void push(V value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        array[++top] = value;
        currentSize++;
    }

    public V pop() {
        if (isEmpty()) {
            return null;
        }
        currentSize--;
        return array[top--];
    }
}
