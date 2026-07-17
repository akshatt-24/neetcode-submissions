class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;
    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    public void push(int x) {
        first.offer(x);
    }
    
    public int pop() {
        int s = first.size();
        for(int i = 0; i < s - 1; i++) {
            second.offer(first.poll());
        }
        // at the end, we have only one element left to pop out from the first queue
        // that is the last pushed element in the stack (LIFO)
        int toPop = first.poll();

        while(!second.isEmpty()) {
            first.offer(second.poll());
        }
        return toPop;
    }
    
    public int top() {
        int s = first.size();
        for(int i = 0; i < s - 1; i++) {
            second.offer(first.poll());
        }
        // at the end, we have only one element left to pop out from the first queue
        // that is the last pushed element in the stack (LIFO)
        int top = first.poll();
        
        while(!second.isEmpty()) {
            first.offer(second.poll());
        }
        first.offer(top);
        return top;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */