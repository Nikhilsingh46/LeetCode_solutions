class Solution {
    public int lengthOfLongestSubstring(String s) {
         int n = s.length();
        int maxLength = 0;
        
        // HashSet to store the characters in the current window
        HashSet<Character> set = new HashSet<>();
        
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            // If character is already in the set, move left pointer to the right
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add the current character and update the maximum length
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
        
    
}