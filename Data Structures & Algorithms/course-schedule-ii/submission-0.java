class Solution {
    public int[] findOrder(int num, int[][] pre) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[num];
        int n = pre.length;
        for(int i=0;i<num;i++)graph.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            graph.get(pre[i][1]).add(pre[i][0]);
            inDegree[pre[i][0]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        int[] ans = new int[num];
        for(int i=0;i<num;i++){
            if(inDegree[i] == 0)que.add(i);
        }
        int j = 0;
        while(!que.isEmpty()){
            int val = que.poll();
            ans[j++] = val;
            for(int node : graph.get(val)){
                inDegree[node]--;
                if(inDegree[node] == 0){
                    que.add(node);
                }
            }
        }
        if(j!=num)return new int[]{};
        return ans;
    }
}
