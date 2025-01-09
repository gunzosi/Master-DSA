package challenge.Trie;

import challenge.Trie.Helper.Trie;

public class WordFormationFromDictionaryUsingTrie {

    public static boolean isFormationPossible(String[] dictionary, String word) {
        if (word.length() < 2 || dictionary.length < 2) {
            return false;
        }

        Trie trie = new Trie();


        /*
        * for (int i = 0; i < dictionary.length; i++) {
            trie.insert(dictionary[i]);
        }
        * */
        for (String s : dictionary) {
            trie.insert(s);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (trie.search(prefix) && trie.search(suffix)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        String[][] inputs = {
                {"he","hello","home","work"},
                {"play","plot","bat"},
                {"p","q","r"},
                {"abc","def"},
                {"add","addi","number"}
        };

        String[] words={"hehome", "world", "pr", "abcdef", "subtract"};
        int i=0;
        for (String[] input: inputs) {
            StringBuilder dictionary= new StringBuilder("[");
            for (int j = 0; j < input.length; j++){
                if(j!=input.length-1)
                    dictionary.append(input[j]).append(", ");
                else
                    dictionary.append(input[j]);
            }
            dictionary.append("]");

            System.out.println("\tDictionary: " + dictionary);
            System.out.println("\tword: " +words[i] );
            boolean result = isFormationPossible(input,words[i]);
            System.out.println("\n\tResult: " +result );
            System.out.println(new String(new char[75]).replace('\0', '-'));
            i+=1;
        }
    }
}
