import java.util.*;

public class LeetCode151 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] strings = s.split(" ");
        for (String string : strings) {
            if (!string.equals("")) {
                stack.push(string);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }
}
