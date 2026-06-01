class Solution {
    public boolean canFinish(int num, int[][] pre) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = pre.length;
        for(int i=0;i<num;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            graph.get(pre[i][0]).add(pre[i][1]);
        }
        for(int i=0;i<num;i++){
            if(fun(i, graph, new boolean[num]))return false;
        }
        return true;
    }
    private boolean fun(int node, ArrayList<ArrayList<Integer>> graph, boolean[] vis){
        if(vis[node]){
            return true;
        }
        vis[node] = true;
        boolean ans = false;
        for(int val : graph.get(node)){
            ans |= fun(val, graph, vis);
        }
        vis[node] = false;
        return ans;
    }
}
