package codingPattern.KWayMerge;

import codingPattern.SlidingWindow.Helper.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairs {

    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();

        int listLength = list1.length;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        for (int i = 0; i < Math.min(k, listLength); i++) {
            minHeap.offer(new Pair(list1[i] + list2[0], i, 0));
        }

        int counter = 1;

        while(!minHeap.isEmpty() && counter <= k) {
            Pair pair = minHeap.poll();

            int i = pair.i;
            int j = pair.j;

            pairs.add(Arrays.asList(list1[i], list2[j]));

            int nextElement = j + 1;

            if (list2.length > nextElement) {
                minHeap.offer(new Pair(list1[i] + list2[nextElement], i, nextElement));
            }
            counter++;
        }
        return pairs;
    }

    // Driver code
    public static void main(String[] args) {
        int[][]list1 = {{2, 8, 9},
                {1, 2, 300},
                {1, 1, 2},
                {4, 6},
                {4, 7, 9},
                {1, 1, 2}
        };

        int[][]list2 = {
                {1, 3, 6},
                {1, 11, 20, 35, 300},
                {1, 2, 3},
                {2, 3},
                {4, 7, 9},
                {1}
        };
        int[] k = {9, 30, 1, 2, 5, 4};
        for(int i=0; i<k.length; i++){
            List<List<Integer>> result = kSmallestPairs(list1[i], list2[i], k[i]);
            System.out.print(i+1);
            System.out.println(".\tInput lists: "+ Arrays.toString(list1[i])+ ", "+ Arrays.toString(list2[i]));
            System.out.println("\tK = "+k[i]);
            System.out.print("\tPairs with smallest sum are: "+ result);
            System.out.println("\n");
            System.out.println(Print.repeat("-", 100));
        }
    }
}

class Pair {
    int sum;
    int i;
    int j;

    public Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}
