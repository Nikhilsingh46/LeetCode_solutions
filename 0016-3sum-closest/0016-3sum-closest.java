import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum to the first triplet

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;               // Start pointer
            int right = nums.length - 1;   // End pointer

            // Step 3: Use two-pointer technique
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update closest sum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on the comparison
                if (currentSum < target) {
                    left++;  // Increase the sum
                } else if (currentSum > target) {
                    right--; // Decrease the sum
                } else {
                    // If the sum is exactly equal to the target, return it immediately
                    return currentSum;
                }
            }
        }

        return closestSum; // Return the closest sum found
    }
}
