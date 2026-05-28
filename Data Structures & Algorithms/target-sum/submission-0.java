class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        int[][]dp = new int[n][2*sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return fun(nums, 0, target, 0, dp, sum);
    }
    private int fun(int[] nums, int i, int target, int curr, int[][] dp, int sum){
        if(i == nums.length && target == curr)return 1;
        if(i == nums.length)return 0;
        if(dp[i][sum+curr]!= Integer.MAX_VALUE)return dp[i][sum+curr];
        int ans = fun(nums, i+1, target, curr+nums[i], dp, sum);
        ans += fun(nums, i+1, target, curr-nums[i], dp, sum);
        return dp[i][sum+curr] = ans;
    }
}
