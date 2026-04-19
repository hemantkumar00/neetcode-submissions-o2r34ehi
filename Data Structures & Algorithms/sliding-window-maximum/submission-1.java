class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<k && i<k;i++){
            pq.add(nums[i]);
        }
        al.add(pq.peek());
        for(int i = k;i<n;i++){
            pq.remove(nums[i-k]);
            pq.offer(nums[i]);
            al.add(pq.peek());
        }
        int[] ans = new int[al.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}
