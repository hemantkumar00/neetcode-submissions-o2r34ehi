class KthLargest {

    PriorityQueue<Integer> que;
    int k;
    public KthLargest(int k, int[] nums) {
        this.que = new PriorityQueue<>();
        this.k = k;
        for(int val : nums){
            que.offer(val);
            if(que.size() > k)que.poll();
        }
    }
    
    public int add(int val) {
        que.offer(val);
        if(que.size() > k)que.poll();
        return que.peek();
    }
}
