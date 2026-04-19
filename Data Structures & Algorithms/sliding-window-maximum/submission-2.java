class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // int n = nums.length;
        // ArrayList<Integer> al = new ArrayList<>();
        // for(int i=0;i<k && i<k;i++){
        //     pq.add(nums[i]);
        // }
        // al.add(pq.peek());
        // for(int i = k;i<n;i++){
        //     pq.remove(nums[i-k]);
        //     pq.offer(nums[i]);
        //     al.add(pq.peek());
        // }
        // int[] ans = new int[al.size()];
        // for(int i=0;i<ans.length;i++){
        //     ans[i] = al.get(i);
        // }
        // return ans;

        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int idx = 0;

        for(int i = 0;i< n;i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])dq.pollLast();
            dq.offerLast(i);
            if(i>=k-1){
                ans[idx++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
