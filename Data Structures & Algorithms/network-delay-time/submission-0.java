class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int len = times.length;
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            int v = times[i][0];
            int u = times[i][1];
            int dis = times[i][2];
            graph.get(v).add(new int[]{u,dis});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] value = pq.poll();
            int dis = value[0];
            int v = value[1];
            for(int[] val : graph.get(v)){
                int currDist = dis + val[1];
                int u = val[0];
                if(currDist < dist[u]){
                    dist[u] = currDist;
                    pq.add(new int[]{currDist, u});
                }
            }
        }
        int ans = 0;
        for(int i = 1;i<=n;i++){
            ans = Math.max(ans, dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}