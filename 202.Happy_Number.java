class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n) && n!=1) {
            set.add(n);
            n = ssq(n);
        }
        return n==1;
    }
    int ssq(int n) {
        int s = 0;
        while (n > 0) {
            int d = n%10;
            s += d*d;
            n /= 10;
        }
        return s;
    }
}
