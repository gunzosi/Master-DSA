package challenge.Trie.Helper;

import challenge.Trie.Helper.TrieNode;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int getIndex(char t) {
        return t - 'a';
    }

    public TrieNode getRoot() {
        return root;
    }

    public void insert(String key) {
        if (key == null) {
            return;
        }

        key = key.toLowerCase();
        TrieNode currentNode = root;
        int index;

        for (char c : key.toCharArray()) {
            index = getIndex(c);
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }

        currentNode.markAsLeaf();
    }

    public boolean search(String key) {
        if (key == null) {
            return false;
        }

        key = key.toLowerCase();
        TrieNode currentNode = root;

        for (char c : key.toCharArray()) {
            int index = getIndex(c);
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }

        return currentNode.isEndWord;
    }

    private boolean hasNoChildren(TrieNode currentNode) {
        for (TrieNode child : currentNode.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level) {
        if (currentNode == null) {
            System.out.println("Key does not exist");
            return false;
        }

        if (level == length) {
            if (hasNoChildren(currentNode)) {
                return true;
            }
            currentNode.unMarkAsLeaf();
            return false;
        }

        int index = getIndex(key.charAt(level));
        TrieNode childNode = currentNode.children[index];
        boolean shouldDeleteChild = deleteHelper(key, childNode, length, level + 1);

        if (shouldDeleteChild) {
            currentNode.children[index] = null;
            return !currentNode.isEndWord && hasNoChildren(currentNode);
        }

        return false;
    }

    public void delete(String key) {
        if (root == null || key == null || key.isEmpty()) {
            System.out.println("Null key or Empty trie error");
            return;
        }
        key = key.toLowerCase();
        deleteHelper(key, root, key.length(), 0);
    }
}