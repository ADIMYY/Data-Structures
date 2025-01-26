import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> lefts = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rights = Arrays.asList(')', '>', ']', '}');

    public boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();

        for (char ch: str.toCharArray()) {
            if (isLeft(ch)) st.push(ch);
            
            if (isRight(ch)) {
                if (st.empty()) return false;
                var top = st.pop();
                if (!match(top, ch)) return false;
            }
        }
        return st.empty();
    }
    
    private boolean isLeft(char ch) {
        return lefts.contains(ch);
    }
    
    private boolean isRight(char ch) {
        return rights.contains(ch);
    }
    
    private boolean match(char left, char right) {
        return lefts.indexOf(left) == rights.indexOf(right);
    }
}
