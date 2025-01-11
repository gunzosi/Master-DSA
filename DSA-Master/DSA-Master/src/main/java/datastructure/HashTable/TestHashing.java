package datastructure.HashTable;

public class TestHashing {
    public static String getValue(int key) {
        String[] myString =
                {
                        "I am a programmer, I have no life.",
                        "8 bytes walk into a bar, the bartenders asks \"What will it be?\"One of them says, \"Make us a double.\"",
                        "Computers are useless. They can only give you answers.\n-Pablo Picasso"
                };

        if (key < myString.length) {
            return myString[key];
        }
        else {
            System.out.println("Key not found");
            return " ";
        }
    }

    public static void main(String[] args) {
        int key = 1;
        System.out.println("1 " + getValue(key));
        System.out.println("2 " + getValue(2));
        System.out.println("3 " + getValue(3));
        System.out.println("4 " + getValue(4));
    }
}
