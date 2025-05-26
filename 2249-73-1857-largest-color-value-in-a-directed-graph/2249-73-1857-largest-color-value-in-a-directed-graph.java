class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        // DP array: dp[node][color] = max count of color on path to node
        int[][] dp = new int[n][26];
        
        // Queue for topological sort
        Queue<Integer> queue = new LinkedList<>();
        // Initialize queue and dp for nodes with indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }
        
        int visitedCount = 0;
        int maxColorValue = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visitedCount++;
            
            // Update max color value for this node
            for (int c = 0; c < 26; c++) {
                maxColorValue = Math.max(maxColorValue, dp[node][c]);
            }
            
            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    // Update dp for neighbor
                    int val = dp[node][c] + ((colors.charAt(neighbor) - 'a' == c) ? 1 : 0);
                    if (val > dp[neighbor][c]) {
                        dp[neighbor][c] = val;
                    }
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If not all nodes are visited, graph has cycle
        if (visitedCount != n) return -1;
        
        return maxColorValue;
    }
}