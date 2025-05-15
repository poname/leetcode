// recursive - dfs - fastest
// time: O(n)
// space: O(1)
class Solution {
    public int evalRPN(String[] tokens) {
        return dfs(new int[]{tokens.length-1}, tokens);
    }
    int dfs(int[] i, String[] tokens) {
        String t = tokens[i[0]];
        char s = t.charAt(0);
        i[0]--;
        if (t.length()>1 || (s!='+' && s!='-' && s!='*' && s!='/')) {
            return Integer.valueOf(t);
        }
        int op2 = dfs(i, tokens);
        int op1 = dfs(i, tokens);
        if (s=='+') {
            return op1+op2;
        } else if (s=='-') {
            return op1-op2;
        } else if (s=='*') {
            return op1*op2;
        } else if (s=='/') {
            return op1/op2;
        } else {
            return 0;
        }
    }
}

// no stack - space optimized
// time: O(n)
// space: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[(tokens.length+1)/2];
        int top=0;
        for (String s : tokens) {
            char t = s.charAt(0);
            if(t=='+') {
                int op2 = Integer.valueOf(stack[--top]);
                int op1 = Integer.valueOf(stack[--top]);
                stack[top++] = op1 + op2;
            } else if (t=='-' && s.length()==1) {
                int op2 = Integer.valueOf(stack[--top]);
                int op1 = Integer.valueOf(stack[--top]);
                stack[top++] = op1 - op2;
            } else if (t=='*') {
                int op2 = Integer.valueOf(stack[--top]);
                int op1 = Integer.valueOf(stack[--top]);
                stack[top++] = op1 * op2;
            } else if (t=='/') {
                int op2 = Integer.valueOf(stack[--top]);
                int op1 = Integer.valueOf(stack[--top]);
                stack[top++] = op1 / op2;
            } else {
                stack[top++] = Integer.valueOf(s);
            }
        }
        return stack[0];
    }
}

// stack
// time: O(n)
// space: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            } else if (t.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            } else if (t.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            } else if (t.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
