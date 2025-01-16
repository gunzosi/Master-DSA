package codingPattern.FastAndSlowPointer;

import java.util.Arrays;

public class CircularArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            int slow = i, fast = i;

            boolean direction = nums[i] > 0;

            while(true) {
                slow = nextStep(slow, nums[slow], size);

                if (isNotCycle(nums, direction, slow)) {
                    break;
                }

                fast = nextStep(fast, nums[fast], size);

                if (isNotCycle(nums, direction, fast)) {
                    break;
                }

                fast = nextStep(fast, nums[fast], size);

                if (isNotCycle(nums, direction, fast)) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }

        }
        return false;
    }

    // A function to calculate the next step -- Helper Function -- Hint
    public static int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0) {
            result += size;
        }
        return result;
    }

    // A function to detect a cycle doesn't exist -- Helper Function -- Hint
    public static boolean isNotCycle(int[] nums, boolean prevDirection, int pointer) {
        boolean currDirection = nums[pointer] > 0;

        if (prevDirection != currDirection || Math.abs(nums[pointer] % nums.length) == 0) {
            return true;
        }

        return false;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
