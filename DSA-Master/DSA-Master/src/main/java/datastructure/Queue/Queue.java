package datastructure.Queue;

public class Queue<V> {
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    /* @TypeCasting by OBJECT
       - Java does not allow generic type arrays.
       - So we have used an array of Object type and type-casted it to the generic type V.
       - This type-casting is unsafe and produces a warning.
       - Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    //    HELPER METHOD
    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public V top() {
        return array[front];
    }

    // MAIN METHODS
    public void enqueue(V value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        back = (back + 1) % maxSize; // to keep the index in the range of 0 to maxSize - 1
        array[back] = value;
        currentSize++;
    }

    public V dequeue() {
        if (isEmpty()) {
            return null;
        }

        V temp = array[front];
        front = (front + 1) % maxSize; // to keep the index in the range of 0 to maxSize - 1
        currentSize--;

        return temp;
    }
}
