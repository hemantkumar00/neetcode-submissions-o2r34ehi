class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        // int[][] arr = new int[hm.size()][2];
        // int j = 0;
        // for(Integer value: hm.keySet()){
        //     arr[j][0] = (int)value;
        //     arr[j][1] = hm.get(value);
        //     j++;
        // }
        // Arrays.sort(arr, (a,b) -> b[1]-a[1]);
        // int[] ans = new int[k];
        // for(int i=0;i<k;i++){
        //     if(arr.length > i){
        //         ans[i] = arr[i][0];
        //     }
        // }
        // return ans;

        ArrayList<Integer>[] bucket = new ArrayList[n+1];
        for(Integer value : hm.keySet()){
            Integer freq = hm.get(value);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(value);
        }
        int[] ans = new int[k];
        int index = 0;
        for(int i= n; i>=0 && index < k;i--){
            if(bucket[i] != null){
                for(Integer value : bucket[i]){
                    if(index < k){
                        ans[index] = value;
                        index++;
                    }
                }
            }
        }
        return ans;
    }
}
