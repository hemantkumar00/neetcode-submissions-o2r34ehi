class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int n = stones.length;
        for(int i=0;i<n;i++){
            heap.add(stones[i]);
        }
        while(heap.size()>1){
            int one = heap.poll();
            int two = heap.poll();
            if(one != two){
                heap.add(Math.abs(one-two));
            }
        }
        if(heap.size()==0)return 0;
        return heap.poll();
    }
}
