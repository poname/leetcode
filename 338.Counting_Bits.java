class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int step = 1;
        for (int i=1; i<=n; i++) {
            if (i>=2*step) {
                step *= 2;
            }
            ans[i] = ans[i-step] + 1;
        }
        return ans;
    }
}
