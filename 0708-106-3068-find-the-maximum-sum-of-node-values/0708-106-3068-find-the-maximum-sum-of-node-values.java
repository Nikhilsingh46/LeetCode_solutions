class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int minDiff = Integer.MAX_VALUE;
        int countPositiveGain = 0;

        for (int num : nums) {
            int flipped = num ^ k;
            sum += Math.max(num, flipped);
            
            int diff = Math.abs(flipped - num);
            if (flipped > num) countPositiveGain++;
            minDiff = Math.min(minDiff, diff);
        }

        // If count of positive-gain flips is odd, we must undo one smallest gain
        if (countPositiveGain % 2 != 0) {
            sum -= minDiff;
        }

        return sum;
    }
}
