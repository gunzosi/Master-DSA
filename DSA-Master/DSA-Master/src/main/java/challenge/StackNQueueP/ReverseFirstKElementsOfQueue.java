package challenge.StackNQueueP;

import challenge.StackNQueueP.Helper.MyQueue;
import challenge.StackNQueueP.Helper.MyStack;

import java.util.Arrays;
import java.util.List;

public class ReverseFirstKElementsOfQueue {
    public static void main(String[] args) {
        List<List<Integer>> test_cases = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                Arrays.asList(-2, 1, -5, 45, 6, 3, -9),
                Arrays.asList(1, 2, 5, 0, 7, 4, 23),
                Arrays.asList(7, 3, 5, 6, 8, 12),
                Arrays.asList(5, 67, 43, 23, 12, 56, 78, 98, 6, 21, 9)
        );

        List<Integer> k_values = Arrays.asList(4, 10, -7, 5, 2);

        for (int i = 0; i < test_cases.size(); ++i) {
            MyQueue<Integer> queue = new MyQueue<Integer>();
            for (int item : test_cases.get(i)) {
                queue.enqueue(item);
            }
            int k = k_values.get(i);
            System.out.print((i + 1) + ".\tOriginal Queue: ");
            System.out.println(queueToString(queue));
            System.out.println("\tk value: " + k);
            MyQueue<Integer> reversedQueue = reverseK(queue, k);
            System.out.print("\tQueue after reversal: ");
            System.out.println(queueToString(reversedQueue));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static MyQueue<Integer> reverseK(MyQueue<Integer> queue, int k) {
        if (queue.isEmpty() || k > queue.size() || k < 0) {
            return queue;
        }

        MyStack<Integer> stack = new MyStack<>(queue.size());
        for (int i = 0; i < k; ++i) {
            stack.push(queue.dequeue());
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.enqueue(queue.dequeue());
        }

        return queue;
    }

    // Helper function to convert queue to string
    public static String queueToString(MyQueue<Integer> queue) {
        StringBuilder sb = new StringBuilder("[");
        MyQueue<Integer> tempQueue = new MyQueue<Integer>(queue);
        while(!tempQueue.isEmpty()) {
            sb.append(tempQueue.dequeue());
            if (!tempQueue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
