class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(a.dist, b.dist)
        );
        for(int i=0;i<n;i++){
            Double dist = Math.sqrt((points[i][0] * points[i][0] + points[i][1] * points[i][1]));
            Pair pair = new Pair(dist, points[i]);
            pq.add(pair);
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().location;
        }
        return ans;
    }
}
class Pair{
    Double dist;
    int[] location;
    public Pair(Double dist, int[] location){
        this.dist = dist;
        this.location = location;
    }
}
