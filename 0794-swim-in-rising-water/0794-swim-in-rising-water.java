class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        Set<Integer> set = new HashSet<>();

        dist[0][0] = grid[0][0];
        
        pq.add(new int[]{0, 0, grid[0][0]});
        
        while(pq.size() > 0) {
            int[] arr = pq.poll();
            int r = arr[0], c = arr[1], d = arr[2];
            int k = r*n + c;

            if (set.contains(k)) continue;
            set.add(k);
            
            if (r == n - 1 && c == n - 1) return dist[r][c];
            
            int dir[] = new int[]{-1, 0, 1, 0};
            int dic[] = new int[]{0, 1, 0, -1};
            
            for (int j = 0; j < 4; j++) {
                int r1 = r + dir[j];
                int c1 = c + dic[j];
                
                if (r1 < 0 || c1 < 0 || r1 >= n || c1 >= n) continue;
                int d1 = Math.max(d, grid[r1][c1]);
                int k1 = r1*n + c1;

                if (!set.contains(k1) && d1 < dist[r1][c1]) {
                    dist[r1][c1] = d1;
                    pq.add(new int[]{r1, c1, d1});
                }
            }
        }
        
        return dist[n - 1][n - 1];
    }
}