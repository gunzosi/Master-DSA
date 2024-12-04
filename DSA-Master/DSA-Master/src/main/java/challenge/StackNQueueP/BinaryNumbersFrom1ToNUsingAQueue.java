package challenge.StackNQueueP;

import challenge.StackNQueueP.Helper.MyQueue;

import java.util.Arrays;
import java.util.Collections;

public class BinaryNumbersFrom1ToNUsingAQueue {

    public static void main(String[] args) {
        int[] inputs = { 1, 3, 5, 9, 11 };
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tn: " + inputs[i]);
            System.out.println("\n\tBinary numbers " + Arrays.toString(findBin(inputs[i])));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }

    public static String[] findBin(int n) {
        String[] result = new String[n];
        MyQueue<String> queue = new MyQueue <String> ();

        // Start with '1' in the queue
        queue.enqueue("1");

        // Loop to generate binary numbers up to 'n'
        for (int i = 0; i < n; i++) {
            // Dequeue the front element of the queue
            result[i] = queue.dequeue();

            // Generate new binary numbers by appending '0' and '1' to the dequeued number
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";

            // Enqueue the new binary numbers back into the queue
            queue.enqueue(s1);
            queue.enqueue(s2);
        }

        return result;
    }

}
