class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        fun(ans, new ArrayList<>(), 0, nums, nums.length);
        return ans;
    }
    private void fun(List<List<Integer>> ans, List<Integer> curr, int i, int[] nums, int n){
        
        ans.add(new ArrayList<>(curr));
        for(int j = i;j<n;j++){
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            curr.add(nums[j]);
            fun(ans, curr, j+1, nums, n);
            curr.remove(curr.size()-1);
        }
    }
}
