package challenge.Heap;

import java.util.Arrays;

public class CheckConvert {

    static int[] minHeapify(int maxHeap[], int index, int size) {
        int left = index * 2 + 1;
        int right = (index * 2) + 2;
        int smallest = index;


        if (left < size && maxHeap[smallest] < maxHeap[left]) {
            smallest = left;
        }

        if (right < size && maxHeap[smallest] > maxHeap[right]) {
            smallest = right;
        }

        if (smallest != index) {
            int temp = maxHeap[smallest];
            maxHeap[smallest] = maxHeap[index];
            maxHeap[index] = temp;
            minHeapify(maxHeap, smallest, size);
        }

        return maxHeap;
    }

    static int[] convertMax(int[] maxHeap) {
        int size = maxHeap.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeap = minHeapify(maxHeap, i, size);
        }
        return maxHeap;
    }

    public static void main(String[] args) {
        int[][] max_heaps = {
                {9, 4, 7, 1, -2, 6, 5},
                {468, 397, 361, 336, 324, 318},
                {1000, 800, 500, -900, -1000},
                {5, 4, 3, 2, 1},
                {10, 9, 6, 2, -3, -12, -14}
        };

        for (int i = 0; i < max_heaps.length; ++i) {
            System.out.println((i + 1) + ".\tGiven Max heap: " + Arrays.toString(max_heaps[i]));
            System.out.print("\tConverted Min heap: ");
            int[] min_heap = convertMax(max_heaps[i]);
            System.out.println(Arrays.toString(min_heap));

            System.out.println("-".repeat(100));
        }
    }
}
