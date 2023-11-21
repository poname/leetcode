class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i=digits.length-1; i>=0; i--) {
            int s = digits[i] + c;
            digits[i] = s%10;
            c = s/10;
        }
        if (c > 0) {
            int[] res = new int[digits.length+1];
            res[0] = c;
            for (int i=0; i<digits.length; i++) {
                res[i+1] = digits[i];
            }
            return res;
        } else {
            return digits;
        }
    }
}
