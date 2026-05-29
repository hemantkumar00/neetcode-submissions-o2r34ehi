class MinStack {
    private Stack<Integer> normal;
    private Stack<Integer> min;

    public MinStack() {
        normal = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        normal.push(val);
        if(min.isEmpty()){
            min.push(val);
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!min.isEmpty() && min.peek() < val){
            list.add(min.pop());
        }
        min.push(val);
        for(int i = list.size()-1;i>=0;i--){
            min.push(list.get(i));
        }
    }
    
    public void pop() {
        int val = normal.pop();
        ArrayList<Integer> list = new ArrayList<>();
        while(!min.isEmpty() && min.peek() != val)list.add(min.pop());
        min.pop();
        for(int i = list.size()-1;i>=0;i--){
            min.push(list.get(i));
        }
    }
    
    public int top() {
        return normal.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
