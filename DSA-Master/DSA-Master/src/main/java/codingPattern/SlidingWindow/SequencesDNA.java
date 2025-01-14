package codingPattern.SlidingWindow;

import codingPattern.SlidingWindow.Helper.*;

import java.util.*;

public class SequencesDNA {

    public static Set<String> findRepeatedSequences(String dna, int k) {

        int stringLength = dna.length();

        // Mapping of characters
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        // Base value
        int baseValue = 4;

        // Numeric representation of the sequence
        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[stringLength]));
        Arrays.fill(numbers.toArray(), 0);
        for (int i = 0; i < stringLength; i++) {
            numbers.set(i, mapping.get(dna.charAt(i)));
        }

        // Current hash value
        int hashValue = 0;

        // 1. Hash set to store the unique hash values
        // 2. Output set to store the repeated substrings
        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int i = 0; i < stringLength - k + 1; i++) {

            // If the window is at its initial position, calculate the hash value from scratch
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(baseValue, k - j - 1);
                }
            } else {
                int previousHashValue = hashValue;
                hashValue = ((previousHashValue - numbers.get(i - 1) * (int) Math.pow(baseValue, k - 1)) * baseValue) + numbers.get(i + k - 1);
            }

            // If the current hash value is present in the hash set, the current substring has been repeated, so we add it to the output
            String substring = dna.substring(i, i + k);
            if (hashSet.contains(hashValue)) {
                output.add(substring);
            }

            // We add the evaluated hash value to the hash set
            hashSet.add(hashValue);

            System.out.println("\n\tHash value of " + substring + ": " + hashValue +
                    "\n\tHash Set: " + Print.printSetInt(hashSet) +
                    "\n\tOutput: " + Print.printSetString(output));
        }
        return output;
    }

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) +
                    "\n\n\tRepeated sequences: " + Print.printSetString(findRepeatedSequences(inputsString.get(i), inputsK.get(i))));
            System.out.println(Print.repeat("-", 100));
        }
    }
}
