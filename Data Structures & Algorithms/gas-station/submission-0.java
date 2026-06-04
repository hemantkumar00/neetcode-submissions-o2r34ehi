class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int ans = 0;
        int fuel = gas[0];
        for(int i=1;i<2*n;i++){
            int ind = i%n;
            fuel -= cost[ind-1>=0?ind-1 : n-1];
            if(fuel < 0){
                fuel = gas[ind];
                ans = i;
            }else{
                fuel += gas[ind];
                if(i-ans >= n)return ans;
            }
        }
        return -1;
    }
}
