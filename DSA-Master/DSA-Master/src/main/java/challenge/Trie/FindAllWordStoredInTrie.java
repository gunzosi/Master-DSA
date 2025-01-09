package challenge.Trie;

import challenge.Trie.Helper.Trie;
import challenge.Trie.Helper.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllWordStoredInTrie {

    public static int getMaxDepth(TrieNode root, int level) {
        if (root == null) {
            return level;
        }

        int maxDepth = level;
        for (TrieNode child : root.children) {
            if (child != null) {
                maxDepth = Math.max(maxDepth, getMaxDepth(child, level + 1));
            }
        }

        return maxDepth;
    }
    public static void getWords(TrieNode root, ArrayList< String > result, int level, char[] str) {
        // If the current node marks the end of a word, construct the word and append it to the result list
        if (root.isEndWord) {
            StringBuilder temp = new StringBuilder();
            for (int x = 0; x < level; x++) {
                temp.append(Character.toString(str[x]));
            }
            result.add(temp.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                // Update the word array with the character at the current level
                str[level] = (char)(i + 'a');

                // Recursively explore the child node
                getWords(root.children[i], result, level + 1, str);
            }
        }
    }

    public static ArrayList < String > findWords(TrieNode root) {
        ArrayList<String> result = new ArrayList<String>();
        int size = getMaxDepth(root, 0);
        char[] str = new char[size];
        getWords(root, result, 0, str);
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        int num = 1;
        String[][] words = {
                {"gram", "groom", "ace", "act", "actor"},
                {"abs", "crow", "crop", "abstain", "crunch"},
                {"dorm", "norm", "prom", "loom", "room"},
                {"prey", "prep", "press", "preps", "prefix"},
                {"moon", "once", "face", "dice", "mole"}
        };

        for (String[] wordList: words) {
            Trie t = new Trie();
            for (String w: wordList) {
                System.out.println("Insert word: '" + w + "'");
                t.insert(w);
                ++num;
            }
            List< String > wordsFound = findWords(t.getRoot());
            System.out.print("\nWords found: [");
            for (String word: wordsFound) {
                System.out.print("'" + word + "' ");
            }
            System.out.print("]\n");

            // StringBuilder lineBuilder = new StringBuilder();
            // lineBuilder.append("-".repeat(100));
            String line = "-".repeat(100);
            // StringBuilder lineBuilder = new StringBuilder();
            //            for (int i = 0; i < 100; i++) {
            //                lineBuilder.append("-");
            //            }
            System.out.println(line);
        }
    }
}
