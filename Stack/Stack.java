import java.util.Arrays;

public class Stack {
    private int[] items = new int[5];
    private int[] mins = new int[5];
    private int top;

    Stack() {
        Arrays.fill(mins, Integer.MAX_VALUE);
    }

    public void push(int value) {
        if (top == items.length)
            throw new StackOverflowError();
        items[top++] = value;
        if (value < mins[top - 1])
            mins[top - 1] = value;
    }

    public int pop() {
        if (top == 0)
            throw new IllegalStateException();
        if (items[top - 1] == mins[top - 1])
            mins[top - 1] = Integer.MAX_VALUE;
        return items[--top];
    }

    public int peek() {
        if (top == 0)
            throw new IllegalStateException();

        return items[top - 1];
    }

    public int min() {
        if (top == 0)
            throw new IllegalStateException();
        return mins[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, top);
        return Arrays.toString(content);
    }
}
