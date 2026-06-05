class KthLargest {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int val : nums){
            maxHeap.add(val);
        }
    }
    
    public int add(int val) {
        maxHeap.add(val);
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i] = maxHeap.poll();
        }
        for(int i=0;i<k;i++){
            maxHeap.add(arr[i]);
        }
        return arr[k-1];
    }
}
