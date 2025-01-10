package datastructure.Heaps;

import java.util.Arrays;

public class MinHeap {
    private void minHeapify(int[] heapArray, int index, int heapSize) {
        int smallest = index;

        while (smallest < heapSize / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < heapSize && heapArray[left] < heapArray[index]) {
                smallest = left;
            }

            if (right < heapSize && heapArray[right] < heapArray[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[smallest];
                heapArray[smallest] = temp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    public void buildMinHeap(int[] heapArray, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            minHeapify(heapArray, i, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] heapArray = { 31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
        new MinHeap().buildMinHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+Arrays.toString(heapArray));

    }
}
