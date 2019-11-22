package leetcode;

import java.util.Stack;

/**
 * @author rexthk
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    private static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (pop == '(' && c != ')' || pop == '[' && c != ']' || pop == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
