public class Solution {
    public String convert(String s, int numRows) {
        // Edge case: If numRows is 1 or greater than or equal to the length of the string
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        // Create a list of StringBuilder to represent each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string and append each character to the appropriate row
        for (int i = 0; i < s.length(); i++) {
            rows[currentRow].append(s.charAt(i));

            // Change direction when reaching the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to the next row based on the direction
            currentRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows to form the final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
