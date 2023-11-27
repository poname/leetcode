class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<temperatures.length; i++) {
            while (stack.size()>0 && temperatures[stack.peek()]<temperatures[i]) {
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.push(i);
        }
        return res;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i=0; i<temperatures.length; i++) {
            while (stack.size()>0 && stack.peek()[1]<temperatures[i]) {
                int idx = stack.pop()[0];
                res[idx] = i-idx;
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        return res;
    }
}
