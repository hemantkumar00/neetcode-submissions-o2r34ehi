class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for(int i=1;i<n;i++){
            if(ans == 0)return false;
            ans--;
            ans = Math.max(ans, nums[i]);
        }
        return true;
    }
}
