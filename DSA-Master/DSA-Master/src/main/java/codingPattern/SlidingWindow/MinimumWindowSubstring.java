package codingPattern.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t){
        if(t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> reqCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            reqCount.put(c, reqCount.getOrDefault(c, 0) + 1);
        }

        int current = 0;
        int required = reqCount.size();

        int[] res = {-1, -1};

        int resLen = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (reqCount.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(reqCount.get(c))) {
                    current++;
                }
            }

            // Try to contract the window while all required characters are present
            while (current == required) {
                // Update the result if the current window is smaller than the previous best
                if ((right - left + 1) < resLen) {
                    res[0] = left;
                    res[1] = right;
                    resLen = (right - left + 1);
                }

                // Shrink the window from the left
                char leftChar = s.charAt(left);
                if (reqCount.containsKey(leftChar)) {
                    // Decrement the count of `leftChar` in the window
                    window.put(leftChar, window.get(leftChar) - 1);
                    // If the frequency of `leftChar` in the window is less than required, update `current`
                    if (window.get(leftChar) < reqCount.get(leftChar)) {
                        current--;
                    }
                }
                left++; // Move the left pointer to shrink the window
            }
        }
        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
    public static void main(String[] args) {
        String[] s = {"PATTERN", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD"};
        String[] t = {"TN", "I", "ABC", "RK", "VDD"};

        for (int i = 0; i < s.length; i++) {
            System.out.printf("%d.\ts: %s\n\tt: %s\n\tThe minimum substring containing %s is: %s\n",
                    i + 1, s[i], t[i], t[i], minWindow(s[i], t[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
