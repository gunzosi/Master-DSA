package challenge.HashTable;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayDisjoint {
    public static boolean isDisjoint(int[] arr1, int[] arr2) {
        HashSet<Integer> hSet = new HashSet<>();

        for (int j : arr1) {
            hSet.add(j);
        }

        for (int j : arr2) {
            if (hSet.contains(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {

        int[][] inputArray1 = {
                {2, 5, 10, 30, 45},
                {-5, -42, -31, -21, -10},
                {10, 20, -30, -40, 50},
                {100, 300},
                {500}
        };

        int[][] inputArray2 = {
                {3, 6, 13, 20, 23},
                {-1, -3, -5, -22, -15},
                {60, 70, 80, 90, 100},
                {300, 100},
                {200}
        };


        for (int i = 0; i < inputArray1.length; ++i) {
            System.out.println((i + 1) + ".\tArray1: " +  Arrays.toString(inputArray1[i]));
            System.out.print("\tArray2: "+ Arrays.toString(inputArray2[i])+"\n");
            System.out.print("\n\tResult: "+ isDisjoint(inputArray1[i],inputArray2[i])+"\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));

        }

    }
}
