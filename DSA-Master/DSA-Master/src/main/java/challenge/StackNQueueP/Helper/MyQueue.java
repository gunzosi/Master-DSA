package challenge.StackNQueueP.Helper;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> {
    private final List<T> queue_list;
    private int queue_size;

    public MyQueue() {
        queue_list = new ArrayList<>();
        queue_size = 0;
    }

    public MyQueue(MyQueue<T> other){
        this.queue_list = new ArrayList<>(other.queue_list);
        this.queue_size = other.queue_size;
    }

    public boolean isEmpty() {
        return queue_size == 0;
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }
        return queue_list.getFirst();
    }

    public T rear() {
        if (isEmpty()) {
            return null;
        }
        return queue_list.get(queue_size - 1);
    }

    public int size() {
        return queue_size;
    }

    public void enqueue(T value) {
        queue_list.add(value);
        queue_size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T front = queue_list.removeFirst();
        queue_size--;
        return front;
    }


}
