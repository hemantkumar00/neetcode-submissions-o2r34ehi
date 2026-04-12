class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if((ch>='0' && ch<='9') || (ch>='a' && ch <='z')){
                sb.append(ch+"");
            }else if (ch>='A' && ch<='Z'){
                ch+=32;
                sb.append(ch+"");
            }
        }
        return pal(sb.toString());
    }
    private boolean pal(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(a!=b)return false;
            i++;
            j--;
        }
        return true;
    }
}
