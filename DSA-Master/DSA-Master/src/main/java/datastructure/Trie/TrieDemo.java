package datastructure.Trie;
// Demo for Trie
/*
class TrieDemo{
    public static void main(String[] args)
    {
        Trie t = new Trie();
        System.out.println("Index to insert a = " + t.getIndex('a'));
        System.out.println("Index to insert t = " + t.getIndex('t'));
    }
}*/

import java.util.Arrays;
// Insert
/*
class TrieDemo{
    public static void main(String[] args){
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String[] output = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
        {
            t.insert(keys[i]);
            System.out.println("\""+ keys[i]+ "\"" + "Inserted.");
        }
    }
}
*/

// Search
/*
class TrieDemo{

    public static void main(String[] args){
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String[] output = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        int i;
        for (i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        // Search for different keys
        if(t.search("the"))
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(t.search("these"))
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(t.search("abc"))
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);
    }
}
*/

// Deletion
class TrieDemo{
    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        int i;
        for (i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        // Search for different keys and delete if found
        if(t.search("the"))
        {
            System.out.println("the --- " + output[1]);
            t.delete("the");
            System.out.println("Deleted key \"the\"");
        }
        else System.out.println("the --- " + output[0]);

        if(t.search("these"))
        {
            System.out.println("these --- " + output[1]);
            t.delete("these");
            System.out.println("Deleted key \"these\"");
        }
        else System.out.println("these --- " + output[0]);

        if(t.search("abc"))
        {
            System.out.println("abc --- " + output[1]);
            t.delete("abc");
            System.out.println("Deleted key \"abc\"");
        }
        else System.out.println("abc --- " + output[0]);

        // check if the string has deleted correctly or still present
        if(t.search("abc"))
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);
    }
}
