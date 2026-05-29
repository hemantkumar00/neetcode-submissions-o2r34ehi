class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        int[] right = new int[n];
        Arrays.fill(right, n);
        Stack<Integer>ls = new Stack<>();
        Stack<Integer>rs = new Stack<>();
        for(int i=0;i<n;i++){
            while(!ls.isEmpty() && heights[ls.peek()]>= heights[i])ls.pop();
            if(!ls.isEmpty())left[i] = ls.peek();
            ls.push(i);
            int ind = n-i-1;
            while(!rs.isEmpty() && heights[rs.peek()]>= heights[ind])rs.pop();
            if(!rs.isEmpty())right[ind] = rs.peek();
            rs.push(ind);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int val = (right[i]-1) - (left[i]);
            ans = Math.max(ans, val * heights[i]);
        }
        return ans;
    }
}
