class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int queryIndex = 0;

        // Sort queries based on start index
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        // Max-heap for available queries (sorted by end index descending)
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap for active queries (sorted by end index ascending)
        PriorityQueue<Integer> active = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            // Add all queries starting at or before index i to available heap
            while (queryIndex < q && queries[queryIndex][0] <= i) {
                available.offer(queries[queryIndex][1]);
                queryIndex++;
            }

            // Remove queries from active heap that no longer cover index i
            while (!active.isEmpty() && active.peek() < i) {
                active.poll();
            }

            // Ensure enough active queries to cover nums[i]
            while (active.size() < nums[i]) {
                if (available.isEmpty() || available.peek() < i) {
                    return -1; // Cannot cover index i
                }
                active.offer(available.poll());
            }
        }

        // Remaining queries in available heap can be removed
        return available.size();
    }
}