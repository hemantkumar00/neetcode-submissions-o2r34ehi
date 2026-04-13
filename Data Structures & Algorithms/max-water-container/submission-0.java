class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int ans = 0;
        while(i<j){
            int temp = Math.min(heights[i], heights[j]);
            temp *= (j-i);
            ans = Math.max(ans, temp);
            if(heights[i] < heights[j])i++;
            else j--;
        }
        return ans;
    }
}
