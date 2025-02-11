package codingPattern.KWayMerge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {

        int listLength = lists.size();

        PriorityQueue<int[]>  kthSmallest = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int index = 0; index < listLength; index++) {
            if (lists.get(index).size() == 0) {
                continue;
            } else {
                kthSmallest.offer(new int[]{lists.get(index).get(0), index, 0});
            }
        }

        int numberChecked = 0, smallestNumber = 0;
        while(!kthSmallest.isEmpty()) {
            int[] smallest = kthSmallest.poll();
            smallestNumber = smallest[0];
            int listIndex = smallest[1];
            int numIndex = smallest[2];

            numberChecked++;

            if (numberChecked == k) {
                break;
            }

            if (numIndex + 1 < lists.get(listIndex).size()) {
                kthSmallest.offer(new int[]{lists.get(listIndex).get(numIndex + 1), listIndex, numIndex + 1});
            }
        }


        return smallestNumber;
    }

    // Driver code
    public static void main(String[] args) {

        List<List<List<Integer>>> lists = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(2, 6, 8),
                        Arrays.asList(3, 6, 10),
                        Arrays.asList(5, 8, 11)
                ),
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5),
                        Arrays.asList(6, 7, 8, 15),
                        Arrays.asList(10, 11, 12, 13),
                        Arrays.asList(5, 10)
                ),
                Arrays.asList(
                        List.of(),
                        List.of(),
                        List.of()
                ),
                Arrays.asList(
                        Arrays.asList(1, 1, 3, 8),
                        Arrays.asList(5, 5, 7, 9),
                        Arrays.asList(3, 5, 8, 12)
                ),
                Arrays.asList(
                        Arrays.asList(5, 8, 9, 17),
                        List.of(),
                        Arrays.asList(8, 17, 23, 24)
                )
        );

        int[] k = {5, 50, 7, 4, 8};

        // loop to execute till the length of list k
        for (int i = 0; i < k.length; i++) {
            System.out.println(i + 1 + ".\t Input lists: " + lists.get(i) +
                    "\n\t K = " + k[i] +
                    "\n\t " + k[i] + "th smallest number from the given lists is: " +
                    kSmallestNumber(lists.get(i), k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}
