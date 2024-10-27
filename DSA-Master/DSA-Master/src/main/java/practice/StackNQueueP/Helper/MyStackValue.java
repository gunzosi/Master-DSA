package practice.StackNQueueP.Helper;

public class MyStackValue<V> {
    private int maxSize;
    private int top;
    private V[] array;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public MyStackValue(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        array = (V[]) new Object[maxSize];
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
        if (isEmpty()) {
            return null;
        }
        return array[top];
    }

    public void push(V value) {
        if (isFull()) {
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
