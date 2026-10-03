class MinStack {
    Deque<Integer> stack, minstack;
    int min;

    public MinStack() {
        stack = new ArrayDeque<>();
        minstack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.addLast(val);
        if (minstack.isEmpty()) {
            minstack.addLast(val);
        } else {
            minstack.add(Math.min(minstack.getLast(), val));
        }
    }
    
    public void pop() {
        stack.removeLast();
        minstack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minstack.getLast();
    }
}
