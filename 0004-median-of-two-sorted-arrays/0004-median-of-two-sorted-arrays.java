public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to keep binary search efficient
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0, right = m;
        while (left < right) {
            int i = left + (right - left) / 2;
            int j = totalLeft - i;

            if (nums1[i] < nums2[j - 1]) {
                left = i + 1;  // i is too small
            } else {
                right = i;  // i is perfect or too large
            }
        }

        int i = left;
        int j = totalLeft - i;

        // Handle edge cases where i or j is at the boundary of arrays
        int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

        // If the combined array has an odd length, the median is the max of the left half
        if ((m + n) % 2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }

        // If even, the median is the average of the two middle elements
        return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
    }
}
