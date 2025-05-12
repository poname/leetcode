// array - fastest
// time: O(n)
// space: O(n)
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n%2 == 1) return false;
        char[] arr = new char[n/2];
        int j = 0;
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                if (j == arr.length) return false; 
                arr[j++] = c;
            }
            else {
                if (j==0) return false;
                if ((c == ')' && arr[j-1] != '(') || 
                    (c == '}' && arr[j-1] != '{') || 
                    (c == ']' && arr[j-1] != '[')) return false;
                j--;
            }
        }
        return j==0;
    }
}

// stack
// time: O(n)
// space: O(n)
class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                if (stack.size()==0) return false;
                if (c == ')') {
                    if (stack.peek() != '(') return false;   
                } else if (c == '}') {
                    if (stack.peek() != '{') return false;   
                } else if (c == ']') {
                    if (stack.peek() != '[') return false;   
                }
                stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
// stack optimized
class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')'); 
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']'); 
            else {
                if (stack.size()==0 || c!=stack.pop()) return false;
            }
        }
        return stack.size() == 0;
    }
}

// time: O(n^2)
// space: O(n)
class Solution {
    public boolean isValid(String s) {
        while(s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }
}

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
