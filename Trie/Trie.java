import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    public static int ALPHABET_SIZE = 26;
    private class Node {
        private char val;
        private HashMap<Character, Node> childs = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "value=" + val;
        }

        public boolean hasChild(char ch) {
            return childs.containsKey(ch);
        }

        public void addChild(char ch) {
            childs.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return childs.get(ch);
        }

        public Node[] getNodes() {
            return childs.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !childs.isEmpty();
        }

        public void removeChild(char ch) {
            childs.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch: word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contain(String word) {
        if (word == null)
            return false;

        var current = root;
        for (var ch: word.toCharArray()) {
            if (!current.hasChild(ch)) return false;

            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root) {
        // Post-Order
        for (var child: root.getNodes())
            traverse(child);
        
        System.out.println(root.val);
    }

    public void remove(String word) {
        if (word == null)
            return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int idx) {
        if (idx == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(idx);
        var child = root.getChild(ch);
        if (child == null)
            return;
        
        remove(child, word, idx + 1);

        if (!child.hasChildren() && !child.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if (root == null)
            return;
        
        if (root.isEndOfWord)
            words.add(prefix);

        for (var child: root.getNodes()) {
            findWords(child, prefix + child.val, words);
        }
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null)
            return null;
        
        var current = root;
        for (var ch: prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node root) {
        int count = 0;
        if (root.isEndOfWord) count++;

        for (var child: root.getNodes()) {
            count += countWords(child);
        }
        return count;
    }

    public String longestCommonPrefix() {
        var current = root;
        var prefix = new StringBuilder();

        if (current == null) return "";
        while (current != null && !current.isEndOfWord && current.childs.size() == 1) {
            var next = current.getNodes()[0];
            prefix.append(current.val);
            current = next;
        }
        if (current != null) {
            prefix.append(current.val);
        }
        return prefix.toString();
    }
}
