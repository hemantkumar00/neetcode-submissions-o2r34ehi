class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    que.add(new Node(i,j));
                }
            }
        }
        int[] x = {0,0,1,-1};
        int[] y = {1,-1,0,0};
        int ans = 0;
        while(true){
            int len = que.size();
            for(int i=0;i<len;i++){
                Node node = que.poll();
                for(int it = 0;it<4;it++){
                    int xx = node.i + x[it];
                    int yy = node.j + y[it];
                    if(xx>=0 && xx < n && yy >=0 && yy < m && grid[xx][yy]==1){
                        grid[xx][yy] = 2;
                        que.add(new Node(xx,yy));
                    }
                }
            }
            if(que.isEmpty())break;
            ans++;
        }
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1)return -1;
            }
        }
        return ans;
    }
}
class Node{
    int i;
    int j;
    public Node(int i,int j){
        this.i = i;
        this.j = j;
    }
}
