class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if(s.charAt(0) == '0')return 0;
        return fun(s, 0, dp);
    }
    private int fun(String s, int i, int[]dp){
        if(i>=s.length())return 1;
        String st = s.substring(i, i+1);
        int te = Integer.parseInt(st);
        int ans = 0;
        if(dp[i]!=0)return dp[i];
        if(te > 0)ans = fun(s, i+1, dp);
        if(te == 0)return 0;
        if(i< s.length()-1){
            String temp = s.substring(i,i+2);
            int val = Integer.parseInt(temp);
            if(val >0 && val <= 26){
                ans += fun(s, i+2, dp);
            }
        }
        return dp[i] = ans;
    }
}
