package challenge.StackNQueueP;

import challenge.StackNQueueP.Helper.MyStack;

public class QueueWithStack2 {
    MyStack<Integer> stack1;
    MyStack<Integer> stack2;

    public QueueWithStack2(int maxSize) {
        stack1 = new MyStack<Integer>(maxSize);
        stack2 = new MyStack<Integer>(maxSize);
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
