import java.util.ArrayList;
public class Tree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private Node root;

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.left;
            else if (value > current.value)
                current = current.right;
            else
                return true;
        }
        return false;
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.print(root.value + " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int height() {
        return height(root);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private int min(Node root) {
        if (root == null)
            throw new IllegalStateException();
        
        if (root.left == null)
            return root.value;
        
        return min(root.left);
    }

    public int min() {
        return min(root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null) {
            return first.value == second.value && 
                equals(first.left, second.left) && 
                equals(first.right, second.right);
        }
        return false;
    }

    public boolean eqauls(Tree other) {
        if (other == null) return false;
        return equals(root, other.root);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;
        
        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.left, min, root.value - 1) && isBinarySearchTree(root.right, root.value + 1, max);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void getNodeAtDistance(Node root, int k, ArrayList<Integer> list) {
        if (root == null) return;

        if (k == 0) {
            list.add(root.value);
            return;
        }

        getNodeAtDistance(root.left, k - 1, list);
        getNodeAtDistance(root.right, k - 1, list);
    }

    public ArrayList<Integer> getNodeAtDistance(int k) {
        var list = new ArrayList<Integer>();
        getNodeAtDistance(root, k, list);
        return list;
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++){
            var list = getNodeAtDistance(i);
            System.out.println(list.toString());
        }
    }
}
