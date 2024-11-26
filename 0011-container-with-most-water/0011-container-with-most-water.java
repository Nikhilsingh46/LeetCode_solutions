class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        // Two-pointer approach
        while (left < right) {
            // Calculate the area with the current left and right pointers
            int width = right - left;
            int currentArea = Math.min(height[left], height[right]) * width;

            // Update max area
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
