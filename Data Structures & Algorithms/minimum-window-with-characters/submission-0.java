class Solution {
    public String minWindow(String s, String t) {
        int ans = Integer.MAX_VALUE;
        String str = "";
        int[] arr = new int[256];
        int n = t.length();
        for(int i=0;i<n;i++){
            arr[t.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++) {
            int[] temp = arr.clone();
            for(int j = i;j<s.length();j++){
                temp[s.charAt(j)]--;
                if(fun(temp)){
                    if(ans > (j-i+1)){
                        ans = j-i+1;
                        str = s.substring(i, j+1);
                    }
                }
            }
        }
        return str;
    }
    private boolean fun(int[] arr){
        for(int i=0;i<256;i++){
            if(arr[i] > 0)return false;
        }
        return true;
    }
}
