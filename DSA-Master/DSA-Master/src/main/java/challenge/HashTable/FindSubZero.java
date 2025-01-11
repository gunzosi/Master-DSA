package challenge.HashTable;

import java.util.HashMap;

public class FindSubZero {
    static boolean findSubZero(int[] arr) {
        HashMap<Integer, Integer> ht = new HashMap<>();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0 || sum == 0 || ht.containsKey(sum)) {
                return true;
            }

            ht.put(sum, i);
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] inputs = {
                {10, 4, 10, -56, 23, 7, 2, -2, 9},
                {-3, 3},
                {2, -5, -4, 43, 2},
                {-7, 1, 2, 5, -6 , 1, -3, 3, -17},
                {25, 50, 75, 100, 400}
        };

        int[] sizes = {9, 2, 5, 9, 5};

        for (int i = 0; i < inputs.length; ++i) {
            System.out.print((i + 1) + ".\tArray: [");
            for (int j = 0; j < sizes[i]; j++) {
                System.out.print(inputs[i][j]);
                if (j < sizes[i] - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println("\tResult: " + (findSubZero(inputs[i]) ? "True" : "False"));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
