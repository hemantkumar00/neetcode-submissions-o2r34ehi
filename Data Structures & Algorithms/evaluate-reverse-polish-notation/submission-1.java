class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int n = tokens.length;
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+")){
                int one = Integer.parseInt(st.pop());
                int two = Integer.parseInt(st.pop());
                st.push(String.valueOf(one + two));
            }else if(tokens[i].equals("*")){
                int one = Integer.parseInt(st.pop());
                int two = Integer.parseInt(st.pop());
                st.push(String.valueOf(one * two));
            }else if(tokens[i].equals("-")){
                int one = Integer.parseInt(st.pop());
                int two = Integer.parseInt(st.pop());
                st.push(String.valueOf(two - one));
            }else if(tokens[i].equals("/")){
                int one = Integer.parseInt(st.pop());
                int two = Integer.parseInt(st.pop());
                st.push(String.valueOf(two / one));
            }else st.push(tokens[i]);
        }
        return Integer.parseInt(st.pop());
    }
}
