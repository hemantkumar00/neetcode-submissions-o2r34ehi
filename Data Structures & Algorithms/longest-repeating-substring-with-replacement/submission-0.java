class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        for(int i = 0; i< s.length(); i++){
            int index = s.charAt(i) - 'A';
            arr[index]++;
            maxFreq = Math.max(maxFreq, arr[index]);
            while((i - left + 1) - maxFreq > k){
                arr[s.charAt(left)- 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
