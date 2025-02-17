public class PriorityQueueWithHeap {
    private Heap heap = new Heap();

    public void enqueue(int val) {
        heap.insert(val);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
