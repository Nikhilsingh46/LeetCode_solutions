class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0, maxSum = 0, currSum = 0;

        while (right < nums.length) {
            if (!set.contains(nums[right])) {
                set.add(nums[right]);
                currSum += nums[right];
                maxSum = Math.max(maxSum, currSum);
                right++;
            } else {
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}
