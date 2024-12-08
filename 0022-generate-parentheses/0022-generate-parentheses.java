import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string is valid and complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add an open parenthesis if it's valid
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add a close parenthesis if it's valid
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
