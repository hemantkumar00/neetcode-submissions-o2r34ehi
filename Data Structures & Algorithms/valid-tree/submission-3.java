class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++)al.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            if(edges[i][0] == edges[i][1])return false;
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }
        boolean val = dfs(0, -1, al, vis);
        for(int i=0;i<n;i++){
            if(!vis[i])return false;
        }
        return val;
    }
    private boolean dfs(int node, int pre, ArrayList<ArrayList<Integer>> al, boolean[] vis){
        if(vis[node])return false;
        vis[node] = true;
        for(int val : al.get(node)){
            if(val != pre){
                if(!dfs(val, node, al, vis))return false;
            }
        }
        return true;
    }
}
