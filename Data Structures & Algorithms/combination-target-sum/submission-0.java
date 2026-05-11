class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    private void fun(int[] nums, int i, int target, List<Integer> curr, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
        }
        if(target < 0)return;
        for(int j = i;j<nums.length;j++){
            curr.add(nums[j]);
            fun(nums, j, target - nums[j], curr, ans);
            curr.remove(curr.size()-1);
        }
    }
}
