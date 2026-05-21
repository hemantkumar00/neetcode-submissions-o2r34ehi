class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        int ans = fun(coins, amount, dp, 0);
        return ans >= 1000000 ? -1: ans;
    }
    private int fun(int[] coins, int amount, int[][] dp, int i){
        if(amount ==0)return 0;
        if(amount <  0 || i>=coins.length) return 10000000;
        if(dp[i][amount]!=0)return dp[i][amount];
        int ans = fun(coins, amount-coins[i], dp, i)+1;
        ans = Math.min(ans, fun(coins, amount, dp, i+1));
        return dp[i][amount] = ans;
    }
}
