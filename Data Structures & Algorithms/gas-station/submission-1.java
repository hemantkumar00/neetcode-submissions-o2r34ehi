class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            int dif = gas[i]-cost[i];
            total += dif;
            tank += dif;
            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
