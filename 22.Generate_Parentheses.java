// optimized
// time: O(n * Cn) -> O(4^n/n^0.5)
// space: O(n)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        char[] stack = new char[2*n];
        bt(0, 0, n, stack, output);
        return output;
    }
    void bt(int open, int closed, int n, char[] stack, List<String> output) {
        if (open==n && closed==n) {
            output.add(new String(stack));
            return;
        }
        if (open < n) {
            stack[open+closed] = '(';
            bt(open+1, closed, n, stack, output);
        }
        if (closed < open) {
            stack[open+closed] = ')';
            bt(open, closed+1, n, stack, output);
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        gen(n, n, "", out);
        return out;
    }
    private void gen(int open, int close, String pref, List<String> ans) {
        if (close == 0) {
            ans.add(pref);
            return;
        }
        if (close > open) {
            gen(open, close-1, pref+")", ans);
        }
        if (open > 0) {
            gen(open-1, close, pref+"(", ans);
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        bt(n, n, stack, output);
        return output;
    }
    void bt(int open, int closed, Stack<Character> stack, List<String> output) {
        if (open==0 && closed==0) {
            output.add(stack.stream().map(s -> s.toString()).collect(Collectors.joining("")));
            return;
        }
        if (open > 0) {
            stack.add('(');
            bt(open-1, closed, stack, output);
            stack.pop();
        }
        if (closed > open) {
            stack.add(')');
            bt(open, closed-1, stack, output);
            stack.pop();
        }
    }
}

// Brute force
// time: O(n * 2^(2*n))
// space: O(n)
class Solution {
    public List<String> generateParenthesis(int n) {
        char[] temp = new char[2*n];
        List<String> output = new ArrayList<>();
        rec(0, temp, output);
        return output;
    }
    void rec(int i, char[] temp, List<String> output) {
        if (i == temp.length) {
            if (isValid(temp)) output.add(new String(temp));
            return;
        }
        temp[i] = '(';
        rec(i+1, temp, output);
        temp[i] = ')';
        rec(i+1, temp, output);
    }
    boolean isValid(char[] input) {
        int diff = 0;
        for (char i : input) {
            diff += (i=='(') ? 1 : -1;
            if (diff < 0) return false;
        }
        return diff==0;
    }
}
