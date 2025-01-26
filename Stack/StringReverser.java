import java.util.Stack;

public class StringReverser {
    public String reverse(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch: str.toCharArray())
            st.push(ch);

        StringBuffer rev = new StringBuffer();
        while (!st.isEmpty())
            rev.append(st.pop());

        return rev.toString();
    }
}