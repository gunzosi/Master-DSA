package codingPattern.TwoPointer;

import java.util.Arrays;
import java.util.List;

public class ReverseWord {

    private static void strRev(char[] str, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = str[startRev];
            str[startRev] = str[endRev];
            str[endRev] = temp;
            startRev++;
            endRev--;
        }
    }

    public static String reverseWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ").trim();

        char[] charArray = sentence.toCharArray();
        int strLen = charArray.length - 1;

        strRev(charArray, 0, strLen);

        for (int start = 0, end = 0; end <= strLen; ++end) {
            if (end == strLen || charArray[end] == ' ') {
                int endIdx = (end == strLen) ? end : end - 1;
                strRev(charArray, start, endIdx);
                start = end + 1;
            }
        }

        return new String(charArray);
    }

    // Driver code
    public static void main(String[] args) {
        List<String> stringsToReverse = Arrays.asList(
                "Hello World",
                "a   string   with   multiple   spaces",
                "Case Sensitive Test 1234",
                "a 1 b 2 c 3 d 4 e 5",
                "     trailing spaces",
                "case test interesting an is this"
        );

        for (int i = 0; i < stringsToReverse.size(); i++) {
            System.out.println((i + 1) + ".\tOriginal string: '" + stringsToReverse.get(i) + "'");
            System.out.println("\tReversed string: '" + reverseWords(stringsToReverse.get(i)) + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
