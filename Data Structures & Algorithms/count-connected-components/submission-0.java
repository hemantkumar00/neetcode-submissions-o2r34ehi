class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(vis, i, graph);
            }
        }
        return count;
    }
    private void dfs(boolean[] vis, int node, ArrayList<ArrayList<Integer>> graph){
        vis[node] = true;
        for(int val : graph.get(node)){
            if(!vis[val]){
                dfs(vis, val, graph);
            }
        }
    }
}
