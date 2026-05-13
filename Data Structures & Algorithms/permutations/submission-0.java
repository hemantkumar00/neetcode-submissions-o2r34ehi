class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, ans);
        return ans;
    }
    private void fun(int[] arr, int i, List<List<Integer>> list){
        if(i>= arr.length){
            int n = arr.length;
            List<Integer> temp = new ArrayList<>();
            for(int val : arr){
                temp.add(val);
            }
            list.add(temp);
            return;
        }
        for(int j = i; j< arr.length; j++){
            int a = arr[i];
            arr[i] = arr[j];
            arr[j] = a;
            fun(arr, i+1, list);
            a = arr[i];
            arr[i] = arr[j];
            arr[j] = a;
        }
    }
}
