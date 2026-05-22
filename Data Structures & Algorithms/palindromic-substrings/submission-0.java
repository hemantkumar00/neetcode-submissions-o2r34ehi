class Solution {
    public int countSubstrings(String s) {
        int ans = 1;
        for(int i=1;i<s.length();i++){
            ans+=fun(s,i,i);
            ans += fun(s, i-1,i);
        }
        return ans;
    }
    private int fun(String s, int i, int j){
        int count = 0;
        while(i>=0 && j< s.length()){
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(a==b){
                count++;
                i--;
                j++;
            }else break;
        }
        return count;
    }
}
