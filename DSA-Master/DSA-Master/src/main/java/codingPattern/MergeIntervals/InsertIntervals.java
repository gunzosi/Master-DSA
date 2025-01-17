package codingPattern.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int i = 0;
        int n = existingIntervals.length;

        List<int[]> outputList = new ArrayList<>();
        while (i < n && existingIntervals[i][0] < newStart) {
            outputList.add(existingIntervals[i]);
            i += 1;
        }

        if (outputList.isEmpty() || outputList.getLast()[1] < newStart) {
            outputList.add(newInterval);
        } else {
            outputList.getLast()[1] = Math.max(outputList.getLast()[1], newEnd);
        }

        while (i < n) {
            int[] ei = existingIntervals[i];
            int start = ei[0];
            int end = ei[1];
            if (outputList.getLast()[1] < start) {
                outputList.add(ei);
            } else {
                outputList.getLast()[1] = Math.max(outputList.getLast()[1], end);
            }
            i += 1;
        }
        return outputList.toArray(new int[0][0]);
    }


    // Driver Code
    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
