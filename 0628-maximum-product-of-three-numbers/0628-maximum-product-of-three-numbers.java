class Solution {
    public int maximumProduct(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        
        int n = nums.length;

        // The maximum product will either be:
        // 1. The product of the three largest numbers.
        // 2. The product of the two smallest numbers (in case they are negative) and the largest number.
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int option2 = nums[0] * nums[1] * nums[n - 1];

        // Return the maximum of the two options
        return Math.max(option1, option2);
    }
}