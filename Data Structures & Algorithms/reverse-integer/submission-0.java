class Solution {
    public int reverse(int x) {
        long ans = 0L;
        boolean isNegative = false;
        if(x<0){
            isNegative = true;
            x*=-1;
        }
        while(x>0){
            int last = x%10;
            x /= 10;
            ans *= 10;
            ans += last;
        }
        if(isNegative){
            ans*=-1;
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)return 0;
        return (int)ans;
    }
}
