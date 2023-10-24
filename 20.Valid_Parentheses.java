class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']' || c == '}' || c == ')') {
                if (stack.size() == 0) {
                    return false;
                } else {
                    char t = stack.pop();
                    if ((c == ']' && t != '[') || (c == '}' && t != '{') || (c == ')' && t != '(')) {
                        return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
