class Solution {
    public String intToRoman(int num) {
        // Arrays for Roman numeral symbols and their corresponding integer values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Iterate through values and symbols
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]); // Append the Roman numeral
                num -= values[i];         // Subtract the value
            }
        }

        return roman.toString();
    }
}
