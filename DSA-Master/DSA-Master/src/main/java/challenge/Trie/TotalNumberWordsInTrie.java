package challenge.Trie;

import challenge.Trie.Helper.Trie;
import challenge.Trie.Helper.TrieNode;

public class TotalNumberWordsInTrie {
    public static int totalWords(TrieNode root) {
        if (root == null) {
            return 0;
        }

        int result = root.isEndWord ? 1 : 0;

        for (TrieNode child : root.children) {
            result += totalWords(child);
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] words = {
                {"hello", "world", "python", "programming"},
                {"app", "apple", "applepie"},
                {"dog", "dig", "ham", "hamster", "dino"},
                {"sun", "burn"},
                {"red", "blue", "green", "yellow", "orange", "purple"}
        };

        for (String[] wordList : words) {
            Trie trie = new Trie();
            System.out.println("Inserting words:");
            for (String word : wordList) {
                System.out.println("'" + word + "'");
                trie.insert(word);
            }

            int total = totalWords(trie.getRoot());
            System.out.println("\nTotal words: " + total);
            System.out.println("-".repeat(75));
        }
    }
}