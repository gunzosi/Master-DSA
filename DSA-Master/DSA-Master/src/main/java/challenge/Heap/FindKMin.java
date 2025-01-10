package challenge.Heap;

import challenge.Heap.Helper.MinHeap;

import java.util.Arrays;

public class FindKMin {

    public static int[] findKSmallest(int[] arr, int k) {
        int arraySize = arr.length;
        if (k <= arraySize) {
            int[] result = new int[k];

            for (int i = 0; i < k; i++) {
                result[i] = MinHeap.removeMin(arr, arraySize);
                --arraySize;
            }

            return result;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {3, 2, 41, 3, 34},
                {-5, -4, -3, -2, -1},
                {-1, 2, 3, -4, -10},
                {1, 2},
                {-3}
        };

        int[] k = {3, 4, 2, 1, 1};

        for (int i = 0; i < inputs.length; ++i) {
            System.out.println((i + 1) + ".\tInput array: " +  Arrays.toString(inputs[i]));
            System.out.print("\n\tk: "+ k[i]);
            System.out.print("\n\tFinal array: "+ Arrays.toString(findKSmallest(inputs[i],k[i]))+"\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));

        }
    }
}
