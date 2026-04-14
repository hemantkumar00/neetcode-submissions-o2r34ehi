class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] arr = new int[n];
        arr[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            arr[i] = Math.max(arr[i+1], height[i]);
        }
        int ans = 0;
        for(int i=1;i<n;i++){
            int temp = Math.min(arr[i], height[i-1]);
            temp = temp - height[i];
            if(temp > 0)ans+=temp;
            height[i] = Math.max(height[i-1],height[i]);
        }
        return ans;
    }
}
