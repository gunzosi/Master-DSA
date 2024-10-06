package datastructure.Stack;

public class Stack<V> {
    private final int maxSize;
    private int top;
    private final V[] array;

    /*
    * @Array in JAVA
    *
    * 1. Java does not allow GENERIC TYPE Array. So we have used on ARRAY of OBJECT type
    * and type-casted it to the generic type V.
    * 2. This type-casting is unsafe and produces a warning
    * 3. Comment out the Line below and execute again to see the warning
    * */

    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1;
        array = (V[]) new Object[max_size]; //type casting Object[] to V[]
    }

    // ------- HELPER METHOD

    /*
    * Returns the maximum size capacity
    * Time Complexity : O(1) */
    public int getCapacity() {
        return maxSize;
    }

    /*
    * Return true if Stack is empty
    * Time Complexity : O(1) **/
    public boolean isEmpty() {
        return top == -1;
    }

    /*
    * Return true if Stack is FULL
    * Time Complexity : O(1) **/
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /*
    * Return the Value at top of STACK
    * Time Complexity : O(1) **/
    public V top() {
        if (isEmpty())
            return null;
        return array[top];
    }

    // ------- Main Methods

    /*
    * Insert a Value to the TOP OF STACK
    * Time Complexity : O(1) **/
    public void push(V value) {
        if (isFull()) {
            System.err.println("Stack is FULL");
            return;
        }
        array[++top] = value; // //increments the top and adds value to updated top
    }

    /*
    * Delete a Value from the TOP OF STACK
    * Time Complexity : O(1) **/
    public V pop() {
        if (isEmpty()) {
            return null;
        }

        return array[top--]; //returns the top and decrements the top
    }



}
