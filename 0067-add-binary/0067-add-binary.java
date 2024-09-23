public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int maxLen = Math.max(lenA, lenB);
        char[] result = new char[maxLen + 1]; // Extra space for possible carry
        int carry = 0;
        int i = lenA - 1, j = lenB - 1, index = maxLen;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
                j--;
            }

            carry = sum / 2; // Calculate new carry
            result[index] = (char) (sum % 2 + '0'); // Store the result bit
            index--;
        }

        // If no carry, return the result starting from index + 1
        return new String(result, index + 1, maxLen - index);
    }
}