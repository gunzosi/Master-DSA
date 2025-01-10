package challenge.Heap.Helper;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int maxIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);
        int n = heap.size();

        if (left < n && heap.get(left) > heap.get(maxIndex)) {
            maxIndex = left;
        }

        if (right < n && heap.get(right) > heap.get(maxIndex)) {
            maxIndex = right;
        }

        if (i != maxIndex) {
            swap(i, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public void push(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public int pop() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

//        int root = heap.get(0);
//        heap.set(0, heap.get(heap.size() - 1));
//        heap.remove(heap.size() - 1);
        int root = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();
        heapifyDown(0);
        return root;
    }
}
