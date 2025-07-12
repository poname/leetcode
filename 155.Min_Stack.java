// true one stack
// time: O(1)
// space: O(n)

/**
    scenario 1
    val, min,    stack, min
1.  x,   0    -> x,     x
2.  x+d, x    -> d,     x

    scenario 2
    val, min,    stack, min
1.  x,   0    -> x,     x
2.  x-d, x    -> -d,    x-d

when popping restoring prev_min depends on top
 */

class MinStack {

    Stack<Long> stack;
    long min = 0;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.size() == 0) {
            min = val;
        }
        stack.push(val - min);
        if (val < min)
            min = val;
    }

    public void pop() {
        long top = stack.pop();
        if (top < 0)
            min -= top;
    }

    public int top() {
        return (int) (min + Math.max(stack.peek(), 0));
    }

    public int getMin() {
        return (int) min;
    }
}

class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
        min = 0L;
    }
    
    public void push(int val) {
        if (stack.empty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push((long)val - min);
            min = Math.min(min, val);
        }
    }
    
    public void pop() {
        Long top = stack.pop();
        if (top < 0) {
            min = min - top;
        }
    }
    
    public int top() {
        if (stack.peek() < 0) {
            return (int)min;
        } else {
            return (int)(stack.peek() + min);
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

// one stack
// time: O(1)
// space: O(n)
class MinStack {
    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
        stack.push(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
    }

    public void push(int val) {
        stack.push(new int[]{val, Math.min(stack.peek()[1], val)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

// two stacks
// time: O(1)
// space: O(n)
class MinStack {
    Stack<Integer> stack, min;

    public MinStack() {
        stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        min.push(Math.min(min.peek(), val));
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}


class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        min.push(min.size()>0 ? Math.min(min.peek(), val): val);
    }
    
    public void pop() {
        min.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
