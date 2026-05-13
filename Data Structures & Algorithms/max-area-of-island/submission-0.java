class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, fun(grid, i, j));
                    
                }
            }
        }
        return ans;
    }
    private int fun(int[][] grid, int i, int j){
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j] == 0)return 0;
        int[] x = {0,1,-1,0};
        int[] y = {1,0,0,-1};
        grid[i][j] = 0;
        int ans = 1;
        for(int k = 0;k<4;k++){
            ans += fun(grid, i+x[k], j+y[k]);
        }
        return ans;
    }
}

