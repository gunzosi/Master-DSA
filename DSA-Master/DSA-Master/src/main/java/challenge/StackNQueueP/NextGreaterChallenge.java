package challenge.StackNQueueP;

import challenge.StackNQueueP.Helper.MyStack;

import java.util.Arrays;

public class NextGreaterChallenge {

    public static void main(String[] args) {
        int[][] inputs = {
                {4, 6, 3, 2, 8, 1, 9, 9, 9},
                {33, 20, 105, 88},
                {12, 5, 44, 56, 46, 78},
                {1, 2, 3, 4, 5},
                {150, 125, 100, 75, 50, 25, 0}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + "\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\n\tResult: " + Arrays.toString(nextGreaterElement(inputs[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int[] nextGreaterElement(int[] arr) {
        MyStack< Integer > stack = new MyStack < > ();
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        for (int i = arr.length - 1; i >= 0; i--) {
            // While stack has elements and the current element is greater than peek element, pop all elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If the stack has an element, the peek element will be greater than ith element
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return res;
    }
}
