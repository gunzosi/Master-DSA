package challenge.HashTable;

import java.util.*;

public class FindSum {
    public static int[] findSumHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> foundValues = new HashMap<>();

        for (int num : nums) {
            int complement = k - num;

            if (foundValues.containsKey(complement)) {
                return new int[]{complement, num};
            }

            foundValues.put(num, num);
        }

        return new int[]{};
    }

    public static int[] findSumSet(int[] nums, int value) {
        Set<Integer> foundValues = new HashSet<>();

        for (int num : nums) {
            int complement = value - num;

            if (foundValues.contains(complement)) {
                return new int[]{complement, num};
            }

            foundValues.add(num);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 4},
                {1, 2},
                {2, 2},
                {-4, -1, -9, 1, -7},
                {25, 50, 75, 100, 400}
        };

        int[] k = {5, 3, 4, -3, 425};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\tk: " + k[i]);
            int[] result = findSumHashMap(inputs[i], k[i]);
//            int[] result = findSumSet(inputs[i], k[i]);
            System.out.println("\n\tResult: " + Arrays.toString(result));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
