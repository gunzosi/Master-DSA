package challenge.StackNQueueP;

public class TwoStack<V> {
    private int arraySize;
    private V[] array;
    // Store VALUE of top indices of 1st and 2nd STACK
    private int top1, top2;

    @SuppressWarnings("unchecked")
    public TwoStack(int arraySize) {
        this.arraySize = arraySize;
        this.top1 = -1;
        this.top2 = arraySize;
        array = (V[]) new Object[arraySize]; // Type casting from V[] to Object[]
    }

    // Insert at top of 1st STACK
    public void push1(V value) {
        if (top1 < top2 - 1) {
            array[++top1] = value;
        } else {
            System.out.println("Stack is full");
            System.exit(1);
        }
    }

    // Insert at Top of 2nd STACK
    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        } else {
            System.out.println("Stack is full");
            System.exit(1);
        }
    }

    // Remove and Return value from top of first STACK
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        } else {
            System.out.println("Stack is empty");
            System.exit(1);
            return null;
        }
    }

    // Remove and Return value from top of 2nd STACK
    public V pop2() {
        if (top2 < arraySize) {
            return array[top2++];
        } else {
            System.out.println("Stack is empty");
            System.exit(1);
            return null;
        }
    }

}
