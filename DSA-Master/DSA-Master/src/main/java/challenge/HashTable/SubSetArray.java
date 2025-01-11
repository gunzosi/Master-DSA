package challenge.HashTable;

import java.util.Arrays;
import java.util.HashSet;

public class SubSetArray {
    public static boolean IsSubset(int[] array1, int[] array2) {
        for (int element : array2) {
            boolean found = false;
            for (int item : array1) {
                if (element == item) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsSubset2(int[] array1, int[] array2) {
        HashSet<Integer> setArray1 = new HashSet<>();
        for (int j : array1) {
            setArray1.add(j);
        }

        for (int j : array2) {
            if (!setArray1.contains(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] input1 = {
                {9, 4, 7, 1, -2, 6, 5},
                {34, 19},
                {1, 2, 5, 0, 7, 4, 23},
                {-4, 6, 8, 1, 3, 14, 5, 7, 29},
                {52, 57, 23, -6, 22, -16, 78, 98, 46, 24, 19},
        };

        int[][] input2 = {
                {7, 1, -2},
                {34},
                {},
                {14, -4, 29},
                {7, -6, 8, -4},
        };

        for (int i = 0; i < input1.length; i++) {
            System.out.println((i + 1) + ".\tArray1: " + Arrays.toString(input1[i]));
            System.out.println("\tArray2: " + Arrays.toString(input2[i]));
            System.out.println("\tResult: " + IsSubset2(input1[i], input2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
