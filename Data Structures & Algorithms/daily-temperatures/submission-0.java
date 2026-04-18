class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans  = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && temperatures[st.peek()] <= temperatures[i])st.pop();
            if(!st.empty()){
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }
}
