public class AVLTree {
    private class AVLNode {
        private int height;
        private int val;
        private AVLNode left;
        private AVLNode right;

        public AVLNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "value = " + this.val;
        }
    }
    private AVLNode root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private AVLNode insert(AVLNode root, int val) {
        if (root == null) {
            return new AVLNode(val);
        }

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        setHeight(root);
        
        return balance(root);
    }
    
    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (blancedFactor(root.left) < 0)
                root.left = rotateLeft(root.left);
            return rotateRight(root);
        } 
        else if (isRightHeavy(root)) {
            if (blancedFactor(root.right) > 0)
                root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return blancedFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return blancedFactor(node) < -1;
    }

    private int blancedFactor(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    private int height(AVLNode node) {
        return (node == null ? -1 : node.height);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(AVLNode node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = blancedFactor(node);
        if (balanceFactor < -1 || balanceFactor > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }
}
