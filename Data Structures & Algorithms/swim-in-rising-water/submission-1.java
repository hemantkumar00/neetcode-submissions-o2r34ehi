class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        boolean[][] vis = new boolean[n][n];
        pq.offer(new int[]{0,0,grid[0][0]});

        int[] x = {0,0,1,-1};
        int[] y = {-1,1,0,0};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int maxHeight = curr[2];

            if(vis[i][j])continue;
            vis[i][j] = true;

            if(i == n-1 && j==n-1)return maxHeight;

            for(int k =0;k<4;k++){
                int ni = i+x[k];
                int nj = j+y[k];
                if(ni >=0 && ni < n && nj >=0 && nj <n && !vis[ni][nj]){
                    pq.offer(new int[]{ni, nj, Math.max(maxHeight, grid[ni][nj])});
                }
            }
        }
        return -1;
    }

    // brute force
    // private int fun(int[][] grid, int i, int j, boolean[][] vis){
    //     if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j])return Integer.MAX_VALUE;
    //     if(i==grid.length-1 && j==grid[0].length-1)return grid[i][j];
    //     int[] x = {0,0,1,-1};
    //     int[] y = {1,-1,0,0};
    //     vis[i][j] = true;
    //     int val = Integer.MAX_VALUE;
    //     for(int k=0;k<4;k++){
    //         val = Math.min(val, fun(grid, i+x[k] , j + y[k], vis));
    //     }
    //     vis[i][j] = false;
    //     if(val == Integer.MAX_VALUE)return val;
    //     return Math.max(val, grid[i][j]);
    // }
}
