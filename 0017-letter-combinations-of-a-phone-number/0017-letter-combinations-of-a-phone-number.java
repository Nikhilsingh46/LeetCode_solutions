import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        // List to store the result
        List<String> result = new ArrayList<>();

        // Base case: if input is empty, return empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Mapping of digits to letters
        String[] mapping = {
            "",     // 0 (not used)
            "",     // 1 (not used)
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        // Helper function for backtracking
        backtrack(result, digits, 0, new StringBuilder(), mapping);

        return result;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder current, String[] mapping) {
        // Base case: if the current combination is complete, add it to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the digit and its corresponding letters
        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];

        // Loop through each letter and backtrack
        for (char letter : letters.toCharArray()) {
            current.append(letter);                // Choose a letter
            backtrack(result, digits, index + 1, current, mapping); // Explore
            current.deleteCharAt(current.length() - 1); // Undo the choice
        }
    }
}
