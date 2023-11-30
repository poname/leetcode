class Solution {
    public int reverse(int x) {
        int val = Math.abs(x);
        int rev = 0;
        while (val>0) {
            if (Integer.MAX_VALUE/10 < rev) {
                return 0;
            }
            rev *= 10;
            rev += val%10;
            val /= 10;
        }
        return x<0 ? -rev : rev;
    }
}

class Solution {
    public int reverse(int x) {
        char[] min = String.valueOf(Integer.MIN_VALUE).toCharArray();
        char[] max = String.valueOf(Integer.MAX_VALUE).toCharArray();
        char[] num = String.valueOf(x).toCharArray();
        int n = num.length;
        char[] rev = new char[n];
        if (num[0] == '-') {
            rev[0] = '-';
            for (int i=1; i<n; i++) {
                rev[n-i] = num[i];
            }
            if (rev.length == min.length) {
                for (int i=0; i<n; i++) {
                    if (rev[i] > min[i]) {
                        return 0;
                    } else if (rev[i] < min[i]) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
            return Integer.valueOf(new String(rev));
        } else {
            for (int i=0; i<n; i++) {
                rev[n-1-i] = num[i];
            }
            if (rev.length == max.length) {
                for (int i=0; i<n; i++) {
                    if (rev[i] > max[i]) {
                        return 0;
                    } else if (rev[i] < max[i]) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
            return Integer.valueOf(new String(rev));
        }
    }
}
