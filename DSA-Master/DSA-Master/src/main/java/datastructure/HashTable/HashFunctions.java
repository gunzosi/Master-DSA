package datastructure.HashTable;

public class HashFunctions {

    public static int hashModular(int key, int size)
    {
        return key % size;
    }

    public static int hashTruncation(int key) {
        return key % 500; // key up to 3 digits because 500 is 3 digits
    }

    public static int hashFold(int key, int chunkSize) // Define the size of each divided portion
    {
        System.out.println("Fold -- Key: " + key);
        String strKey = Integer.toString(key);
        int hashVal = 0;
        System.out.println("Fold -- Chunks:");

        for (int i = 0; i < strKey.length(); i += chunkSize) {
            if (i + chunkSize <= strKey.length()) {
                System.out.println(strKey.substring(i, i + chunkSize));
                hashVal += Integer.parseInt(strKey.substring(i, i + chunkSize));
            } else {
                System.out.println(strKey.substring(i, strKey.length()));
                hashVal += Integer.parseInt(strKey.substring(i, strKey.length()));
            }
        }
        return hashVal;
    }

        public static void main(String[] args)
    {
        int [] list = new int[10];// List of size 10
        int key = 35;
        int indexModular = hashModular(key, 10); // Fit the key into the list size
        int indexTruncate = hashTruncation(key); // Fit the key into the list size
        System.out.println("The index for \"Modular\" key " + key + " is " + indexModular);
        System.out.println("The index for \"Truncation\" key " + key + " is " + indexTruncate);

        // Folding
        int keyFold = 3456789;
        int chunkSize = 2;
        System.out.println("Hash Key: " + hashFold(keyFold, chunkSize));
    }
}
