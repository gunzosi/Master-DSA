package challenge.StackNQueueP;

import challenge.StackNQueueP.Helper.MyStack;

public class QueueWithStack1 {
    MyStack<Integer> stack1;
    MyStack<Integer> stack2;

    public QueueWithStack1(int maxSize){
        stack1 = new MyStack<Integer>(maxSize);
        stack2 = new MyStack<Integer>(maxSize);
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return result;
    }
}
