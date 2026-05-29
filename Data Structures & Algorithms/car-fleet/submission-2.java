class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Integer> stack = new Stack<>();
        double[][] arr = new double[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
            int val = target - position[i];
            arr[i][2] = (double)val/speed[i];
        }
        
        Arrays.sort(arr, (a, b) -> Double.compare((double)a[0], (double)b[0]));
        double time = arr[n-1][2];
        int ans = 1;
        for(int i=n-2;i>=0;i--){
            if(time < arr[i][2]){
                time = arr[i][2];
                ans++;
            }
        }
        return ans;
    }
}
