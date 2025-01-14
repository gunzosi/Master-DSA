package codingPattern.SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Stream;

public class SlidingWindowMaximum {
    public static Deque<Integer> cleanUp(int i, Deque<Integer> currentWindow, int[] nums) {
        while(!currentWindow.isEmpty() && nums[i] >= nums[currentWindow.getLast()]) {
            System.out.println("\t\tAs nums[" + i + "] = " + nums[i] + " is greater than or equal to nums[" + currentWindow.getLast() + "] = " + nums[currentWindow.getLast()] + ",");
            System.out.println("\t\tremove " + currentWindow.getLast() + " from currentWindow");
            currentWindow.removeLast();
        }

        return currentWindow;
    }

    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        if (nums.length == 1) {
            return nums;
        }

        int[] output = new int[nums.length - w + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();

        System.out.println("\n\tFinding the maximum in the first window:");

        for (int i = 0; i < w; i++) {
            System.out.println("\tAdding nums[" + i + "] = " + nums[i] + " to the first window:\n\t\tInitial state of currentWindow: " + currentWindow);
            SlidingWindowMaximum.cleanUp(i, currentWindow, nums);

            currentWindow.add(i);
            System.out.println("\t\tAfter adding nums[" + i + "] = " + nums[i] + " to currentWindow: " + currentWindow);
            System.out.println("\t\tFinal state of currentWindow: " + currentWindow);
        }

        output[0] = nums[currentWindow.getFirst()];

        System.out.println("\n\tFinding the maximum in the remaining windows:");

        for (int i = w; i < nums.length; i++) {
            System.out.printf("\tAdding nums[%d] = %d to currentWindow:\n\t\tInitial state of currentWindow: %s\n", i, nums[i], currentWindow);
            cleanUp(i, currentWindow, nums);

            if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - w)) {
                System.out.printf("\t\tIndex %d has fallen out of the current window,\n", currentWindow.getFirst());
                System.out.println("\t\tso, remove it");
                currentWindow.removeFirst();
            }

            // append the index of the current element to currentWindow
            System.out.printf("\t\tAppending %d to currentWindow\n", i);
            currentWindow.add(i);
            System.out.printf("\t\tFinal state of currentWindow: %s\n", currentWindow);

            // adding the maximum element of the current window to the output list
            output[i - w + 1] = nums[currentWindow.getFirst()];
        }

        // return the array containing output
        return output;
    }

    public static void main(String[] args) {
        int[] windowSizes = {3, 3, 3, 3, 2, 4, 3, 2, 3, 6};
        int [][] numLists = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
                {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                {4, 5, 6, 1, 2, 3},
                {9, 5, 3, 1, 6, 3},
                {2, 4, 6, 8, 10, 12, 14, 16},
                {-1, -1, -2, -4, -6, -7},
                {4, 4, 4, 4, 4, 4}
        };

        for (int i = 0; i < numLists.length; i++) {
            System.out.println(i + 1 + ".\tInput array:\t" + Arrays.toString(numLists[i]));
            System.out.println("\tWindow size:\t" + windowSizes[i]);
            System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(findMaxSlidingWindow(numLists[i], windowSizes[i])));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }
}
