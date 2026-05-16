class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = s.substring(0,1);
        for(int i=1;i<n;i++){
            String temp = fun(s,i,i);
            if(temp.length() >= ans.length()) ans = temp;
            if(s.charAt(i)==s.charAt(i-1)){
                String str = fun(s,i-1,i);
                if(str.length()>= ans.length())ans = str;
            }
        }
        return ans;
    }
    private String fun(String s, int i, int j){
        while(i>=0 && j < s.length() ){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else break;
        }return s.substring(i+1,j);
    }
}
