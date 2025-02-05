package challenge.StackNQueueP;

import challenge.StackNQueueP.Helper.MyStackValue;

public class MinStack {
    int maxSize;
    MyStackValue<Integer> mainStack;
    MyStackValue<Integer> minStack;

    public MinStack(int maxSize) {
        this.maxSize = maxSize;
        mainStack = new MyStackValue<>(maxSize);
        minStack = new MyStackValue<>(maxSize);
    }

    public int pop() {
        minStack.pop();
        return mainStack.pop();
    }

    public void push(Integer value) {
        mainStack.push(value);
        // Solution 1 with MyStack helper class
        /*if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }*/

        // Solution 2 : with MyStackValue helper class
        if (minStack.isEmpty() || minStack.top() > value) {
            minStack.push(value);
        } else {
            minStack.push(minStack.top());
        }
    }

    public int min() {
        return minStack.top();
    }
}


class Driver {
    public static void main(String args[]) {

        String[][] calls = {    {"MinStack","push()","push()","min()","pop()"},
                {"MinStack","push()","pop()","push()","min()"},
                {"MinStack","push()","push()","push()","push()", "pop()","min()"},
                {"MinStack","push()","min()","push()"},
                {"MinStack","push()","push()","min()","push()","min()"}};

        int[][] inputs = {{Integer.MAX_VALUE, 3, 7, Integer.MAX_VALUE, 7},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -4, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 100, 300, -200, -140, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 100000, Integer.MAX_VALUE, -100000},
                {Integer.MAX_VALUE, 54, 89, Integer.MAX_VALUE, 45, Integer.MAX_VALUE}};

        int[] sizes = {5, 5, 7, 4, 6};

        for (int i = 0; i < calls.length; i++) {
            MinStack stack = new MinStack (sizes[i]);

            System.out.println("\t Starting operations: ");

            for (int j = 0; j < calls[i].length; j++) {
                switch (calls[i][j]) {
                    case "push()" -> {
                        String inputString = "push(" + inputs[i][j] + ")";
                        System.out.println("\t\t" + inputString);
                        stack.push(inputs[i][j]);
                    }
                    case "pop()" -> System.out.println("\t\tpop()   returns " + stack.pop());
                    case "min()" -> System.out.println("\t\tmin()   returns " + stack.min());
                }
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}