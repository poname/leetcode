class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) l++;
            else if (!Character.isLetterOrDigit(s.charAt(r))) r--;
            else if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}

// time: O(n)
// space: O(n)
class Solution {
    public boolean isPalindrome(String s) {
        int r = s.length()-1;
        int l = 0;
        while (l < r) {
            if (!alphaNum(s.charAt(l))) l++;
            else if (!alphaNum(s.charAt(r))) r--;
            else if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++; r--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    boolean alphaNum(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        char[] input = s.toCharArray();
        int j = input.length-1;
        while (i<j) {
            if (!isGood(input[i])) {
                i++;
            } else if (!isGood(input[j])) {
                j--;
            } else {
                if (eqIgCase(input[i], input[j])) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        } 
        return true;
    }
    private boolean isGood(char c) {
        return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
    }
    private boolean eqIgCase(char a, char b) {
        if (a>='A' && a<='Z') {
            a -= 'A';
            a += 'a';
        }
        if (b>='A' && b<='Z') {
            b -= 'A';
            b += 'a';
        }
        return a == b;
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
