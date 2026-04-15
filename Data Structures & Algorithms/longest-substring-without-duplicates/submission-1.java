class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int n = s.length();
        int ans = 0;
        int j = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            while(hs.contains(ch)){
                hs.remove(s.charAt(j));
                j++;
            }
            hs.add(ch);
            ans = Math.max(ans, i-j+1);
        }
        return ans;
    }
}
