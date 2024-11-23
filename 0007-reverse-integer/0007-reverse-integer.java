class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10; // Extract the last digit
            x /= 10; // Remove the last digit from x

            // Check for overflow/underflow before multiplying by 10
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow for positive numbers
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Underflow for negative numbers
            }

            reversed = reversed * 10 + digit; // Add the digit to the reversed number
        }

        return reversed;
    }
}
