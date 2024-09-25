import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        // Stack to store the opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If it's a closing bracket
            else {
                // If stack is empty, return false (no matching opening bracket)
                if (stack.isEmpty()) return false;

                // Pop the top element of the stack and check if it matches the closing bracket
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty at the end, all brackets are matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test1 = "()[]{}";
        String test2 = "([)]";
        String test3 = "{[]}";

        System.out.println(solution.isValid(test1));  // true
        System.out.println(solution.isValid(test2));  // false
        System.out.println(solution.isValid(test3));  // true
    }
}
