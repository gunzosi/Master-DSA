package challenge.Trie.Helper;

public class TrieNode {
    public TrieNode[] children;
    public static final int ALPHABET_SIZE = 26;
    public boolean isEndWord;

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