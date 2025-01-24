public class Array {
    private int[] items;
    private int count;
    
    public Array(int length) {
        items = new int[length];
    }

    public void insert(int val) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        items[count++] = val;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public int indexOf(int val) {
        for (int i = 0; i < count; i++)
            if (items[i] == val) return i;
        return -1;
    }

    public int max() {
        int max = 0;
        for (int i = 0; i < count; i++)
            if (items[i] > max) max = items[i];
        return max;
    }

    public Array intersect(Array other) {
        Array intersection = new Array(count);
        for (int i = 0; i < count; i++)
            if (other.indexOf(items[i]) >= 0)
                intersection.insert(items[i]);
        return intersection;
    }

    public void reverse() {
        int[] newItems = new int[count];
        for (int i = 0; i < count; i++)
            newItems[i] = items[count - i - 1];
        items = newItems;
    }

    public void insertAt(int index, int val) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        for (int i = count; i > index; i--)
            items[i] = items[i - 1];
        items[index] = val;
        count++;
    }

    public void printe() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
