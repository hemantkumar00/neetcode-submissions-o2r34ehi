class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(new ArrayList<>(), 0, nums, ans);
        return ans;
    }
    private void fun(List<Integer> curr, int i, int [] nums, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));
        if(nums.length <= i)return;
        for(int j = i;j<nums.length;j++){
            curr.add(nums[j]);
            fun(curr, j+1, nums, ans);
            curr.remove(curr.size()-1);
        }
    }
}
