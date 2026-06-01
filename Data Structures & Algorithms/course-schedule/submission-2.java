class Solution {
    public boolean canFinish(int num, int[][] pre) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<num;i++){
            al.add(new ArrayList<>());
        }
        int n = pre.length;
        for(int i=0;i<n;i++){
            al.get(pre[i][0]).add(pre[i][1]);
        }
        int[] vis = new int[num];
        for(int i=0;i<num;i++){
            if(dfs(i, al, vis))return false;
        }
        return true;
    }
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, int[] vis){
        if(vis[node] == 1)return true;
        if(vis[node] == 2)return false;
        vis[node] = 1;
        for(int val : graph.get(node)){
            if(dfs(val, graph, vis))return true;
        }
        vis[node] = 2;
        return false;
    }
}
