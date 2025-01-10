package challenge.Heap;

import challenge.Heap.Helper.MaxHeap;

import java.util.Arrays;

public class FindKLargestElement {
    static int[] findKLargest(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        return Arrays.copyOfRange(nums, 0, k);
    }


    public static int[] findKLargestUtil(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap();

        for (int num : nums) {
            maxHeap.push(num);
        }

        int[] kLargest = new int[k];

        for (int i = 0; i < k; ++i) {
            kLargest[i] = maxHeap.pop();
        }

        return kLargest;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3, 4, 6, 8, 2, 9},
                {10, -20, -40, -30, 50, -10, 90},
                {1, -2, 3, -4, 5, -6, 7},
                {90},
                {11, 41, 71, 91, 31}
        };

        int[] size={6, 7, 7, 1, 5};
        int[] k= {3, 5, 7, 1, 5};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i+1 + ".\tArray: " + Arrays.toString(nums[i]));
            System.out.println("\tK: " + k[i]);

//            int[] result = findKLargest(nums[i], k[i]);
            int[] resultUtilMaxHeap = findKLargestUtil(nums[i], k[i]);

//            System.out.print("\tK Largest elements: " + Arrays.toString(result) + "\n");
            System.out.print("\tK Largest elements: " + Arrays.toString(resultUtilMaxHeap) + "\n");
            System.out.println("-".repeat(100));
        }
    }
}
