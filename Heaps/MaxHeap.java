public class MaxHeap {
    public static void heapify(int[] array){
        var lastParentIdx = array.length / 2 - 1;
        for (var i = lastParentIdx; i >= 0; i--) {
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int idx) {
        var largerIdx = idx;

        var leftIdx = idx * 2 + 1;
        if (leftIdx < array.length && array[leftIdx] > array[largerIdx])
            largerIdx = leftIdx;

        var rightIdx = idx * 2 + 2;
        if (rightIdx < array.length && array[rightIdx] > array[largerIdx])
            largerIdx = rightIdx;

        if (idx == largerIdx) return;

        swap(array, idx, largerIdx);
        heapify(array, largerIdx);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for (var num: array) {
            heap.insert(num);
        }

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }
}
