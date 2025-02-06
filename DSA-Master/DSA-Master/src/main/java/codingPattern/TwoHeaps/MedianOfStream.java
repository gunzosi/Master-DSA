package codingPattern.TwoHeaps;

import codingPattern.SlidingWindow.Helper.Print;

import java.util.PriorityQueue;

class MedianOfStream {

    PriorityQueue<Integer> maxHeapForSmallNum; //containing first half of numbers
    PriorityQueue<Integer> minHeapForLargeNum; //containing second half of numbers

    public MedianOfStream() {
        maxHeapForSmallNum = new PriorityQueue<>((a, b) -> b - a);
        minHeapForLargeNum = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if (maxHeapForSmallNum.isEmpty() || maxHeapForSmallNum.peek() >= num)
            maxHeapForSmallNum.add(num);
        else
            minHeapForLargeNum.add(num);

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeapForSmallNum.size() > minHeapForLargeNum.size() + 1)
            minHeapForLargeNum.add(maxHeapForSmallNum.poll());
        else if (maxHeapForSmallNum.size() < minHeapForLargeNum.size())
            maxHeapForSmallNum.add(minHeapForLargeNum.poll());
    }

    public double findMedian() {
        if (maxHeapForSmallNum.size() == minHeapForLargeNum.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeapForSmallNum.peek() / 2.0 + minHeapForLargeNum.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeapForSmallNum.peek();
    }


    public static void main(String[] args) {
        // Driver code
        int[] nums = {35, 22, 30, 25, 1};
        MedianOfStream medianOfAges = null;
        for(int i=0; i< nums.length; i++){
            System.out.print(i+1);
            System.out.print(".\tData stream: [");
            medianOfAges = new MedianOfStream();
            for(int j=0; j<=i; j++){
                System.out.print(nums[j]);
                if(j != i)
                    System.out.print(", ");
                medianOfAges.insertNum(nums[j]);
            }
            System.out.println("]");
            System.out.println("\tThe median for the given numbers is: " + medianOfAges.findMedian());
            System.out.println(Print.repeat("-", 100));
        }

    }
}