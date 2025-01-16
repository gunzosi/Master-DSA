# 1. Happy Number 

Write an algorithm to determine if a number n is a happy number.

We use the following process to check if a given number is a happy number:

Starting with the given number n , replace the number with the sum of the squares of its digits.
Repeat the process until:
- The number equals 1 , which will depict that the given number n is a happy number.
- The number enters a cycle, which will depict that the given number n is not a happy number.
> Return TRUE if n is a happy number, and FALSE if not.

> Example:
> Input: n = 19
> - Output: true
> - Explanation:
>   - 1^2 + 9^2 = 82 // Result of 19 and take 82 to the next step
>   - => 8^2 + 2^2 = 68 // Where 8^2 take from 82 and 2^2 take from 82
>   - => 6^2 + 8^2 = 100 
>   - => 1^2 + 0^2 + 0^2 = 1

```java
import java.util.*;

public class Main{
    public static boolean isHappyNumber(int n) {

        // Replace this placeholder return statement with your code
        return false;
    }
    
    // Test Case
    public static void main(String[] args) {
        int[] a = {1, 5, 19, 25, 7};
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + 1 + "." + "\tInput Number:" + a[i]);
            System.out.println("\tSum of squared digits: " + sumOfSquaredDigits(a[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
```
# 2. Linked List Cycle

> Helper Code at : 
> - [LinkedListNode.java](../Helper/LinkedListNode.java)
> - [PrintList.java](../Helper/PrintList.java)
> - [LinkedList.java](../Helper/LinkedList.java)

```java
import java.util.*;

class CycleDetection {
    public static boolean detectCycle(LinkedListNode head) {
      // Write your code here
    }
    // Driver code
    public static void main(String args[]) {
        int[][] input = { { 2, 4, 6, 8, 10, 12 }, { 1, 3, 5, 7, 9, 11 },
                { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 } };
        int[] pos = { 0, -1, 1, -1, 2 };
        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                PrintList.printListWithForwardArrow(list.head);
            } else {
                PrintList.printListWithForwardArrowLoop(list.head);
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = list.getLength(list.head);
                LinkedListNode lastNode = list.getNode(list.head, length - 1);
                lastNode.next = list.getNode(list.head, pos[i]);
            }
            System.out.println("\n\tDetected Cycle =  " + detectCycle(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
```

# 3. Middle of the LinkedList

> Helper Code at :
> - [LinkedListNode.java](../Helper/LinkedListNode.java)
> - [PrintList.java](../Helper/PrintList.java)
> - [LinkedList.java](../Helper/LinkedList.java)

```java
public class MiddleNode {
    public static LinkedListNode middleNode(LinkedListNode head) {

        // Replace this placeholder return statement with your code
        return head;
    }

    public static void main( String args[] ) {

        int[][] input = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 2, 1}, {10}, {1, 2}};

        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tInput linked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tMiddle of the linked list is:  " );
            System.out.println(middleNode(list.head).data);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
```
# 4. Circular Array Loop

```java
import java.util.*;

class Solution {
    public static boolean circularArrayLoop(int[] nums) {
      
    }

    // A function to calculate the next step -- Helper Function -- Hint 
    public static int nextStep(int pointer, int value, int size) {
       
    }

    // A function to detect a cycle doesn't exist -- Helper Function -- Hint 
    public static boolean isNotCycle(int[] nums, boolean prevDirection, int pointer) {
      
    }
    // Driver code
    public static void main(String[] args) {
        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = circularArrayLoop(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
```

# 5. Find the Duplicate Number



# 6. Palindrome Linked List 
> Helper Code at :
> - [LinkedListNode.java](../Helper/LinkedListNode.java)
> - [PrintList.java](../Helper/PrintList.java)
> - [LinkedList.java](../Helper/LinkedList.java)
> - [LinkedListReversal.java](../Helper/LinkedListReversal.java)


```java
import java.util.*;

class PalindromeList {
    public static boolean palindrome(LinkedListNode head) {
    
    }

    public static boolean compareTwoHalves(LinkedListNode firstHalf, LinkedListNode secondHalf) {
       
    }

    // Driver code
    public static void main( String args[] ) {
        
        int[][] input={
          {2, 4, 6, 4, 2},
          {0, 3, 5, 5, 0},
          {9, 27, 4, 4, 27, 9},
          {5, 4, 7, 9, 4, 5},
          {5, 10, 15, 20, 15, 10, 5}
          };
        
        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tLinked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tIs it a palindrome?  ");
            boolean result = palindrome(list.head);
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        
    }
}
```

