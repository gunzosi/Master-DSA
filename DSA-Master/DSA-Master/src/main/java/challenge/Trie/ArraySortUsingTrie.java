package challenge.Trie;

import challenge.Trie.Helper.Trie;
import challenge.Trie.Helper.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySortUsingTrie {
    public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] word) {
        if (root.isEndWord) {
            StringBuilder temp = new StringBuilder();
            for (int x = 0; x < level; x++) {
                temp.append(Character.toString(word[x]));
            }

            result.add(temp.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                word[level] = (char) (i + 'a');
                getWords(root.children[i], result, level + 1, word);
            }
        }
    }

    public static ArrayList<String> sortArray(Trie trie) {
        ArrayList<String> result = new ArrayList<>();
        char[] word = new char[20];
        getWords(trie.getRoot(), result, 0, word);
        return result;
    }

    public static void main(String[] args) {
        String[][] keys = {
                {"gram", "grammar", "grain", "grainy", "grape"},
                {"absent", "absorb", "abstain", "abstract", "absurd"},
                {"dormant", "dormitory", "dormouse", "dormant", "dormant"},
                {"prey", "preach", "prepare", "prestige", "prestigious"},
                {"moon", "moose", "mood", "moot", "moor"}
        };

        for (String[] words : keys) {
            System.out.println("Input: " + Arrays.toString(words));
            Trie t = new Trie();
            for (String word : words) {
                System.out.println("Insert: '" + word + "'");
                t.insert(word);
            }

            ArrayList<String> result = sortArray(t);
            System.out.println("\nOutput: " + result + "\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
