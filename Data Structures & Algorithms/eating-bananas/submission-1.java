class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int n = piles.length;
        int max = piles[0];
        for(int i=0;i<n;i++){
            max = Math.max(max, piles[i]);
        }
        int ans = max;
        while( min < max){
            int mid = (min+max)/2;
            if(fun(mid, piles, h)){
                max = mid;
                ans = mid;
            }else min = mid+1;
        }
        return ans;
    }
    private boolean fun(int n, int[] piles, int h){
        for(int i = 0;i<piles.length;i++){
            int val = (piles[i] + n -1)/n;
            h-=val;
            if(h<0)return false;
        }
        return true;
    }
}
