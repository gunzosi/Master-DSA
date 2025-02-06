package codingPattern.TwoHeaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleMachine {
    public static int minimumMachines(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> machines = new PriorityQueue<>();

        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];

            if (!machines.isEmpty() && machines.peek() <= start)
                machines.poll();

            machines.add(end);
        }

        return machines.size();
    }

    // Driver code
    public static void main(String[] args) {
        int[][][] inputTasksList = {
                {{1, 1}, {5, 5}, {8, 8}, {4, 4}, {6, 6}, {10, 10}, {7, 7}},
                {{1, 7}, {1, 7}, {1, 7}, {1, 7}, {1, 7}, {1, 7}},
                {{1, 7}, {8, 13}, {5, 6}, {10, 14}, {6, 7}},
                {{1, 3}, {3, 5}, {5, 9}, {9, 12}, {12, 13}, {13, 16}, {16, 17}},
                {{12, 13}, {13, 15}, {17, 20}, {13, 14}, {19, 21}, {18, 20}}
        };

        for (int i = 0; i < inputTasksList.length; ++i) {
            System.out.print((i + 1) + ".\t Tasks: [");
            int[][] tasks = inputTasksList[i];
            for (int j = 0; j < tasks.length; ++j) {
                System.out.print("[" + tasks[j][0] + ", " + tasks[j][1] + "]");
                if (j < tasks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println("\t Minimum number of machines: " + minimumMachines(tasks));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }
    }
}
