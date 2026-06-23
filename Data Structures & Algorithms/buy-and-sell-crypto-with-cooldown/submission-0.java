class Solution {
    public int maxProfit(int[] prices) {
        return fun(0, 1, new int[prices.length][2], prices);
    }
    private int fun(int ind, int buy, int[][] dp, int[] prices){
        if(ind >= prices.length)return 0;
        if(dp[ind][buy] != 0)return dp[ind][buy];
        if(buy == 1){
            return dp[ind][buy] = Math.max( -prices[ind] + fun(ind+1, 0, dp, prices), fun(ind+1, 1, dp, prices));
        } else {
            return dp[ind][buy] = Math.max( +prices[ind] + fun(ind+2, 1, dp, prices), fun(ind+1, 0, dp, prices));
        }
    }
}
