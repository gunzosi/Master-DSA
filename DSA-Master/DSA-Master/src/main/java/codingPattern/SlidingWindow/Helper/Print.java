package codingPattern.SlidingWindow.Helper;

import java.util.Set;

public class Print {
    public static String printSetString(Set<String> set) {
        // Convert the set to a string with elements separated by commas
        return "[" + String.join(", ", set) + "]";
    }

    public static String repeat(String str, int times) {
        // Repeat a string 'times' times
        return String.valueOf(str).repeat(Math.max(0, times));
    }

    public static String printSetInt(Set<Integer> set) {
        // Convert the set to a string with elements separated by commas
        return "[" + set.toString().substring(1, set.toString().length() - 1) + "]";
    }
}
