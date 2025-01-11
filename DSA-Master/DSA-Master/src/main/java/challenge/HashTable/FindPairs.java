package challenge.HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class FindPairs {
    public static int[][] findPairs(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int sum = nums[i] + nums[j];
                // Check if pair already exists
                if (map.containsKey(sum)) {
                    // Store the pairs if found
                    int[][] result = new int[2][];
                    result[0] = map.get(sum);
                    result[1] = new int[]{nums[i], nums[j]};
                    return result;
                } else {
                    int[] pair = new int[]{nums[i], nums[j]};
                    map.put(sum, pair);
                }
            }
        }
        // No pairs found
        return null;
    }

    public static void main(String[] args) {
        int[][] numsList = {
                {3, 4, 7, 1, 12, 9, 0},
                {1, 2, 3, 5, 8},
                {10, 20, 30, 40, 50, 60, 70, 5, 65, 15, 25},
                {-5, -3, -1, 0, 2, 4, 6},
                {0, 1, 2, 3, 4, 99}
        };

        // Iterate through each test case
        for (int i = 0; i < numsList.length; i++) {
            int[] nums = numsList[i];
            System.out.println((i + 1) + ".\tnums = " + Arrays.toString(nums));
            int[][] result = findPairs(nums);
            if (result != null) {
                System.out.println("\tFound pairs: " + Arrays.deepToString(result));
            } else {
                System.out.println("\tNo matching pairs found.");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
