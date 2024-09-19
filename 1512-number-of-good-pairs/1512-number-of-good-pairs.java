class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
    
        // Iterate through each pair (i, j) with i < j
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
             // Check if nums[i] is equal to nums[j]
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
    
    return count;       
    }
}