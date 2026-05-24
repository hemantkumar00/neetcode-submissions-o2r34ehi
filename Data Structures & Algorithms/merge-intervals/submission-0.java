class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        ArrayList<int[]> list = new ArrayList<>();
        int[] arr = intervals[0];
        list.add(arr);
        for(int i=1;i<intervals.length;i++){
            if(arr[1] >= intervals[i][0]){
                arr[1] = Math.max(arr[1], intervals[i][1]);
            } else {
                arr = intervals[i];
                list.add(arr);
            }
        }
        int n = list.size();
        int[][] ans = new int[n][2];
        for(int i=0;i<n;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
