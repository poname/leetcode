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
