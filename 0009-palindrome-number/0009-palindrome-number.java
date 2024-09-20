class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }
        
        // Initialize variables to reverse the number
        int original = x;
        int reversed = 0;
        
        // Reverse the number
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        
        // Check if the original number is the same as the reversed number
        return original == reversed;
    }
}
