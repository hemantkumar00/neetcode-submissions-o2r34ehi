class MinStack {
    private Stack<Integer> normal;
    private Stack<Integer> min;

    public MinStack() {
        normal = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        normal.push(val);
        if(min.isEmpty() || min.peek() >= val)min.push(val);
    }
    
    public void pop() {
        int val = normal.pop();
        if(min.peek() == val)min.pop();
    }
    
    public int top() {
        return normal.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
