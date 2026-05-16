class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0], nums[1]);
        return Math.max(fun(nums, 0, n-2), fun(nums, 1, n-1));
    }
    private int fun(int[] nums, int i, int j){
        if(j-i == 0 )return nums[i];
        if(j-i == 1 )return Math.max(nums[i],nums[i+1]);
        int n = nums.length;
        int[] dp = new int[n];
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i],nums[i+1]);
        for(int k = i+2;k<=j;k++){
            dp[k]= Math.max(dp[k-1], dp[k-2]+nums[k]);
        }
        return dp[j];
    }
}
