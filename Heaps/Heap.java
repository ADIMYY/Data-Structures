public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int val) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = val;

        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = items[0];
        items[0] = items[--size];

        bubbleDown();

        return root;
    }

    private void bubbleDown() {
        var idx = 0;
        while (idx < size && !isValidParent(idx)) {
            var largerIdx = largerIdx(idx);
            if (largerIdx == idx) break;
            swap(idx, largerIdx);
            idx = largerIdx;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerIdx(int idx) {
        if (!hasLeft(idx)) return idx;
        if (!hasRight(idx)) return leftIdx(idx);
        return (left(idx) > right(idx)) ? leftIdx(idx) : rightIdx(idx);
    }

    private boolean hasLeft(int idx) {
        return leftIdx(idx) < size;
    }

    private boolean hasRight(int idx) {
        return rightIdx(idx) < size;
    }

    private boolean isValidParent(int idx) {
        if (!hasLeft(idx)) return true;
        
        var isValid = items[idx] >= left(idx);
        if (hasRight(idx))
            isValid &= items[idx] >= right(idx);

        return isValid;
    }

    private int right(int idx) {
        return items[rightIdx(idx)];
    }

    private int left(int idx) {
        return items[leftIdx(idx)];
    }

    private int leftIdx(int idx) {
        return idx * 2 + 1;
    }

    private int rightIdx(int idx) {
        return idx * 2 + 2;
    }

    public boolean isFull() {
        return size == items.length;
    }
    
    private void bubbleUp() {
        var idx = size - 1;
        while (idx > 0 && items[idx] > items[parent(idx)]) {
            swap(idx, parent(idx));
            idx = parent(idx);
        }
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[0];
    }
}
