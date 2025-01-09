package datastructure.Trie;

public class TrieNode {
    public TrieNode[] children;
    public boolean isEndWord;
    public static final int ALPHABET_SIZE = 26;

    public TrieNode() {
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    public void markAsLeaf() {
        this.isEndWord = true;
    }

    public void unMarkAsLeaf() {
        this.isEndWord = false;
    }
}
