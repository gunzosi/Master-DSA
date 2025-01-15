package codingPattern.TwoPointer;


import codingPattern.TwoPointer.Helper.PrintList;

public class SortColor {

    public static int[] sortColors(int[] colors) {
        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;

                current++;
                start++;
            }

            else if (colors[current] == 1) {
                current++;
            }

            else {
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;

                end--;
            }
        }
        return colors;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + PrintList.arrayToString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + PrintList.arrayToString(sortedColors));

            System.out.println(PrintList.repeat("-", 50));
        }
    }
}
