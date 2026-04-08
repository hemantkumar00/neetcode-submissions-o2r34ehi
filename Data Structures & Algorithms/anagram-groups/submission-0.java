class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            int[] arr = new int[26];
            for(int j=0;j<strs[i].length();j++){
                arr[strs[i].charAt(j)-'a']++;
            }
            
            String key = Arrays.toString(arr);

            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(strs[i]);
        }
        return new ArrayList<>(hm.values());
    }
}
