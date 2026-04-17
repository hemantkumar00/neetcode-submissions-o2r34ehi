class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[256];
        int[] arr1 = new int[256];
        int n = s1.length();
        int m = s2.length();
        if(n>m)return false;
        for(int i = 0;i<n && i<m;i++){
            arr[s1.charAt(i)]++;
            arr1[s2.charAt(i)]++;
        }
        if(fun(arr, arr1))return true;
        for(int i = n;i<m;i++){
            arr1[s2.charAt(i)]++;
            arr1[s2.charAt(i-n)]--;
            if(fun(arr, arr1))return true;
        }
        return false;
    }
    private boolean fun(int[] arr1, int[] arr2){
        for(int i=0;i<256;i++){
            if(arr1[i] != arr2[i])return false;
        }
        return true;
    }
}
