class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!set.contains(nums[i]+1)){
                int count = 0;
                int value = nums[i];
                while(set.contains(value)){
                    set.remove(value);
                    value--;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
