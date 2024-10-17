package practice.StackNQueueP;

import practice.StackNQueueP.Helper.MyStack;

public class FindTheCelebrity {
    public static boolean knows(int[][]  matrix, int x, int y) {
        // Returns true if x knows y, else returns false
        return matrix[x][y] == 1;
    }

    public static int findCelebrity(int[][] matrix, int n) {
        MyStack<Integer> stack = new MyStack<>();
        int celebrity = -1;

        for (int i = 0; i < n; ++i) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int x = stack.pop();

            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }

            int y = stack.pop();

            if (knows(matrix, x, y)) {
                // x knows y, discard x and push y back in stack
                stack.push(y);
            } else {
                // y is discarded, x is pushed back
                stack.push(x);
            }
        }

        // Verify the potential celebrity
        for (int j = 0; j < n; ++j) {
            // A celebrity knows no one, and everyone knows the celebrity
            if (celebrity != j && (knows(matrix, celebrity, j) || !knows(matrix, j, celebrity))) {
                return -1;
            }
        }

        return celebrity;
    }

    public static void main(String[] args) {
        int[][][] matrices = {
                { // matrix 1
                        {0, 1, 1, 0},
                        {1, 0, 1, 1},
                        {0, 0, 0, 0},
                        {0, 1, 1, 0}
                },
                { // matrix 2
                        {0, 1, 1, 0},
                        {1, 0, 1, 1},
                        {0, 0, 0, 1},
                        {0, 1, 1, 0}
                },
                { // matrix 3
                        {0, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 0, 0, 1},
                        {1, 1, 1, 0}
                },
                { // matrix 4
                        {0, 1, 0, 0},
                        {0, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 0, 0}
                },
                { // matrix 5
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                }
        };

        int[] n = {4, 4, 4, 4, 5};

        for (int i = 0; i < 5; ++i) {
            System.out.print((i + 1) + ".\tInput matrix: [");
            for (int[] row : matrices[i]) {
                System.out.print(" [");
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.print("]");
            }
            System.out.println("]");

            System.out.println("\tCelebrity: " + findCelebrity(matrices[i], n[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
