package codingPattern.TwoHeaps;

import codingPattern.SlidingWindow.Helper.Print;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeCapital {

    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        int n = capitals.length;
        int currentCapital = c;
        // Insert all capitals values to a min-heap
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; ++i) {
            capitalMinHeap.offer(new int[] {capitals[i], i});
        }
        PriorityQueue<int[]> profitsMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int i = 0;
        // Calculate capital of all the required number of projects
        // containing maximum profit
        while (i < k) {
            // Select projects (in the range of the current capital)
            // then push them onto the max-heap
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
                int[] j = capitalMinHeap.poll();
                profitsMaxHeap.offer(new int[]{profits[j[1]]});
            }
            // check if the max-heap is empty
            if (profitsMaxHeap.isEmpty()) {
                break;
            }
            // Select those projects from the max-heap that contain the maximum profit
            int x = profitsMaxHeap.poll()[0];
            System.out.println("\t\tUpdated capital = "+ currentCapital + " + "+ x);
            currentCapital += x;
            i++;
        }
        return currentCapital;
    }

    public static void main(String[] args) {
        int[] c = { 0, 1, 2, 1, 7, 2 };
        int[] k = { 1, 2, 3, 3, 2, 4 };
        int[][] capitals = {
                {1, 1, 2},
                {1, 2, 2, 3},
                {1, 3, 4, 5, 6},
                {1, 2, 3, 4},
                {6, 7, 8, 10},
                {2, 3, 5, 6, 8, 12}
        };
        int[][] profits = {
                {1, 2, 3},
                {2, 4, 6, 8},
                {1, 2, 3, 4, 5},
                {1, 3, 5, 7},
                {4, 8, 12, 14},
                {1, 2, 5, 6, 8, 9}
        };
        for (int i = 0; i<k.length; i++) {
            System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]));
            System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
            System.out.println("\tNumber of projects: " + k[i]);
            System.out.println("\tStart-up capital: " + c[i]);
            System.out.println("\n\t\tProcessing: ");
            System.out.println("\n\tMaximum Capital earned: " + maximumCapital(c[i], k[i], capitals[i], profits[i]));
            System.out.println(Print.repeat("-", 100));
        }
    }
}