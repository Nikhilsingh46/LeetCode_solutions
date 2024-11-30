import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        // Map Roman numerals to integer values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0; // Resulting integer
        int prevValue = 0; // To track the value of the previous character

        // Iterate through the Roman numeral string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // Check subtraction rule: if current value < previous value, subtract it
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue; // Otherwise, add it
            }

            // Update the previous value
            prevValue = currentValue;
        }

        return result;
    }
}
