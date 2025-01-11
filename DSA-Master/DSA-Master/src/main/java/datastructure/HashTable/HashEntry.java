package datastructure.HashTable;

public class HashEntry {
    public String key;
    public int value;

    public HashEntry next;

    public HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
