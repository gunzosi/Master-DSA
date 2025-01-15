package codingPattern.TwoPointer;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        System.out.println("The element being pointed to by the left pointer is '" + s.charAt(left) + "'");
        System.out.println("The element being pointed to by the right pointer is '" + s.charAt(right) + "'");
        while (left < right) {
            System.out.println("We check if the two elements are indeed the same, in this case...");
            if (s.charAt(left) != s.charAt(right)) // If the elements at index left and index right are not equal,
            {
                System.out.println("The elements aren't the same, hence we return False");
                return false; // then the symmetry is broken, the string is not a palindrome
            }
            System.out.println("They are the same, thus we move the two pointers toward the middle to continue the \nverification process.\n");
            left = left + 1; // Heading towards the right
            right = right - 1; // Heading towards the left
            System.out.println("The new element at the left pointer is " + s.charAt(left));
            System.out.println("The new element at the right pointer is " + s.charAt(right));
        }
        // We reached the middle of the string without finding a mismatch, so it is a palindrome.
        return true;
    }

    //Driver code
    public static void main(String[] arg) {
        String[] testCase = {
                "RACEACAR",
                "A",
                "ABCDEFGFEDCBA",
                "ABC",
                "ABCBA",
                "ABBA",
                "RACEACAR"
        };
        for (int k = 0; k < testCase.length; k++) {
            System.out.println("Test Case #" + (k + 1));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("The input string is " + testCase[k] + "' and the length of the string is " + testCase[k].length() + ".");
            System.out.println("\nIs it a palindrome?..... " + isPalindrome(testCase[k]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
