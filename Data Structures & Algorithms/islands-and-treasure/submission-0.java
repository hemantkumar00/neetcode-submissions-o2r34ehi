class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0)dfs(grid, i, j, n, m, 0);
            }
        }
    }
    private void dfs(int[][] grid, int i, int j, int n, int m, int dist){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] == -1)return;
        if(grid[i][j] < dist)return;
        grid[i][j] = dist;
        dfs(grid,i,j+1,n,m,dist+1);
        dfs(grid,i,j-1,n,m,dist+1);
        dfs(grid,i+1,j,n,m,dist+1);
        dfs(grid,i-1,j,n,m,dist+1);
    }
}
