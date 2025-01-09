package datastructure.Trie;

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public int getIndex(char t) {
        return t - 'a';
    }

    // Function  insert a key into the trie
    public void insert (String key) {
        if (key == null) {
            System.out.println("Null Key can not be Inserted!");
            return;
        }

        key = key.toLowerCase();
        TrieNode currentNode = root;
        int index = 0;

        // Iterate the TRIE with the given character index,
        // If the index points to NULL, then simply create a TrieNode and go down
        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));

            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
                System.out.println(key.charAt(level) + " inserted");
            }
            currentNode = currentNode.children[index];
        }

        // Mark the end character as leaf node
        currentNode.markAsLeaf();
    }

    public boolean search(String key) {
        if (key == null) {
            return false;
        }

        key = key.toLowerCase();
        TrieNode currentNode = root;
        int index = 0;

        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }

        return currentNode.isEndWord;
    }

    //Helper Function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode){
        for (int i = 0; i < currentNode.children.length; i++){
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }

    //Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level)
    {
        boolean deletedSelf = false;

        if (currentNode == null){
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length){
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)){
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else
            {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        }
        else
        {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted)
            {
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currentNode is part of another key
                //and hence we can not delete this node, and it's parent path nodes
                if (currentNode.isEndWord){
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children than currentNode must be part of another key.
                //So, we cannot delete currentNode
                else if (!hasNoChildren(currentNode)){
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else{
                    currentNode = null;
                    deletedSelf = true;
                }
            }
            else
            {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    //Function to delete given key from Trie
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }
}
