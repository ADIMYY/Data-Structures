import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    
    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty()) 
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        var previous = getPrevious(last);
        last = previous;
        previous.next = null;
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        var current = first;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty() || k <= 0 || k > size)
            throw new IllegalStateException();
        
            int index = 1;
        var current = first;
        while (current != null) {
            if (index == size - k + 1) return current.value;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();
        
        if (size == 1) {
            System.out.println(first.value);
            return;
        }
        var current = first;
        int index = 1;
        while (current != null) {
            if (index == size / 2) {
                if (size % 2 == 0)
                    System.out.print(current.value + ", ");
            }
            if (index == size / 2 + 1) {
                System.out.println(current.value);
                return;
            }
            current = current.next;
            index++;
        }
    }

    public boolean hasLoop() {
        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) return true;
        }
        return false;
    }
}