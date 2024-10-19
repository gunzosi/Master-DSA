package practice.StackNQueueP;

import practice.StackNQueueP.Helper.MyStack;

public class ValidParentheses {
    public static boolean isBalanced(String exp) {
        MyStack<Character> stack = new MyStack<>();

        for (int i = 0; i < exp.length(); i++) {
            char character = exp.charAt(i);

            if (character == '}' || character == ')' || character == ']') {
                if (stack.isEmpty()) {
                    // If the stack is empty, there's no opening bracket to match with, so the expression is unbalanced
                    return false;
                }

                // Pop the top element from the stack (most recent opening bracket)
                char topChar = stack.pop();

                if ((character == '}' && topChar != '{') ||
                        (character == ')' && topChar != '(') ||
                        (character == ']' && topChar != '[')) {
                    return false;
                }
            } else {
                // If the character is not a closing bracket, push it onto the stack
                stack.push(character);
            }
        }

        // Replace this placeholder return statement with your code
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] parentheses = {
                "(){}[]",
                "[{()}]",
                "]}){{()}({[",
                "[[{{((}])}])",
                "))))))"
        };

        for (int i = 0; i < parentheses.length; i++) {
            System.out.println((i + 1) + ".\tCheck balanced parentheses: '" + parentheses[i] + "'");
            boolean result = isBalanced(parentheses[i]);

            System.out.println("\tIs the string balanced? " + (result ? "True" : "False"));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
