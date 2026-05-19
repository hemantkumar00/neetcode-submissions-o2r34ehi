class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs= new HashSet<>();
        while(true){
            n = num(n);
            if(n==1)return true;
            if(hs.contains(n))return false;
            hs.add(n);
        }
    }
    private int num(int n){
        int ans = 0;
        while(n>0){
            int val = n%10;
            ans += val*val;
            n/=10;
        }
        return ans;
    }
}
