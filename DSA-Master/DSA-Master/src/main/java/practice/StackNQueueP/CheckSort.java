package practice.StackNQueueP;

import practice.StackNQueueP.Helper.Stack;

public class CheckSort {
    public static void insert(Stack<Integer> stack, int value ) {
        if (stack.isEmpty() || value < stack.top()) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insert(stack, value);
            stack.push(temp);
        }
    }
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int value = stack.pop();
            sortStack(stack);
            insert(stack, value);
        }
        return stack;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {10, 30, 5, 20, 50},
                {-1, -2, -3, -4, -5, -6},
                {3, 2, -1},
                {12},
                {1, -2}
        };

        for (int[] stackValues : inputs) {
            Stack<Integer> stack = new Stack<>(stackValues.length);
            for (int value : stackValues) {
                stack.push(value);
            }
            System.out.print("Original Stack: [");
            for (int i = 0; i < stackValues.length; i++) {
                System.out.print(stackValues[i]);
                if (i < stackValues.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            Stack<Integer> sortedStack = sortStack(stack);
            System.out.print("Sorted Stack: [");
            while (!sortedStack.isEmpty()) {
                System.out.print(sortedStack.pop());
                if (!sortedStack.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.println("]\n" + new String(new char[75]).replace('\0', '-'));
        }
    }
}
