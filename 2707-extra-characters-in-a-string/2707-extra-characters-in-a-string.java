import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();  // Use a set for quick lookup
        for (String word : dictionary) {
            dict.add(word);
        }
        int n = s.length();
        int[] dp = new int[n + 1];  // dp[i] represents the min extra characters up to index i
        
        // Initialize dp array, worst case all characters are extra
        for (int i = 0; i <= n; i++) {
            dp[i] = i;  // Initially, assume we cannot remove any character
        }
        
        // Fill the DP table
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);  // Substring from i to j
                if (dict.contains(sub)) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i]);  // If substring is in dictionary, no extra characters
                }
            }
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);  // At worst, take the current character as extra
        }
        
        return dp[n];  // The answer is the minimum extra characters for the entire string
    }
}
