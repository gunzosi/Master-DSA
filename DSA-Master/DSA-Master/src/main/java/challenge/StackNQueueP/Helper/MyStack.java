package challenge.StackNQueueP.Helper;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private List<T> stack_list;
    private int stack_size;

    public MyStack(int maxSize) {
        this.stack_list = new ArrayList<>();
        this.stack_size = 0;
    }

    public MyStack() {
        this.stack_list = new ArrayList<>();
        this.stack_size = 0;
    }

    public boolean isEmpty() {
        return stack_size == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack_list.get(stack_size - 1);
    }

    public int size() {
        return stack_size;
    }

    public void push(T value) {
        stack_list.add(value);
        stack_size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T top = stack_list.remove(stack_size - 1);
        stack_size--;
        return top;
    }


}
