class Solution {
    public int maximumLength(int[] nums) {
        int maxLen = 0;
        int[][] combinations = { {0, 0}, {0, 1}, {1, 0}, {1, 1} };
        
        for (int[] combo : combinations) {
            int length = 0;
            for (int num : nums) {
                if (num % 2 == combo[length % 2]) {
                    length++;
                }
            }
            maxLen = Math.max(maxLen, length);
        }
        
        return maxLen;
    }
}
