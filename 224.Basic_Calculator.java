// time: O(n)
// space: O(n)
class Solution {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                res += sign * cur;
                cur = 0;
                // sign = 1;
            }
            if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res *= stack.pop();
                res += stack.pop();
            } else if (c == '-') {
                sign = -1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == ' ') {

            } else {
                cur *= 10;
                cur += Character.getNumericValue(c);
            }
        }
        res += sign * cur;
        return res;
    }
}
