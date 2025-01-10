package datastructure.Heaps;

import java.util.Arrays;

public class MaxHeap {
    private void maxHeapify(int[] heapArray, int index, int heapSize) {
        int largest = index;

        while(largest < heapSize / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < heapSize && heapArray[left] > heapArray[index]) {
                largest = left;
            }

            if (right < heapSize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }

            if (largest != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;
            } else {
                break;
            }
        }
    }

    public void buildMaxHeap(int[] heapArray, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(heapArray, i, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
        new MaxHeap().buildMaxHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+Arrays.toString(heapArray));
    }
}
