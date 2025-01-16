package codingPattern.FastAndSlowPointer;

public class HappyNumber {
    public static int sumOfSquaredDigits(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));
        }
        System.out.println("\t\tSum of squared digits: " + totalSum);
        return totalSum;
    }
    public static boolean isHappyNumber(int n) {
        int slowPointer = n; // The slow pointer value
            System.out.println("\tSetting slow pointer = input number " + slowPointer);
            System.out.println("\tSetting fast pointer = sum of squared digits of " + n);
        int fastPointer = sumOfSquaredDigits(n); // The fast pointer value
            System.out.println("\tFast pointer:" + fastPointer);
        while (fastPointer != 1 && slowPointer != fastPointer) { // Terminating condition
             System.out.println("\n\tRepeatedly updating slow and fast pointers\n");
            // Incrementing the slow pointer by 1 iteration
            slowPointer = sumOfSquaredDigits(slowPointer);
             System.out.println("\tThe updated slow pointer is " + slowPointer);
            // Incrementing the fast pointer by 2 iterations
            fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
             System.out.println("\tThe updated fast pointer is " + fastPointer + "\n");
        }
            System.out.println("\tIs it a happy number?: " + (fastPointer == 1)); // If 1 is found then it returns True, otherwise False
        return fastPointer == 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 19, 25, 7};
        for (int i = 0; i < a.length; i++) {
            System.out.println((i + 1) + ".\tInput Number: " + a[i]);
            isHappyNumber(a[i]);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
