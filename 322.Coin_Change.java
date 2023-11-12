class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        for (int c : coins) {
            if (c<=amount) {
                dp[c] = 1;
            }
            
        }
        for (int i=1; i<=amount; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            boolean ok = false;
            for (int c : coins) {
                if (c<=i && dp[i-c]>0) {
                    ok = true;
                    min = Math.min(min, dp[i-c]);
                }
            }
            if (ok) {
                dp[i] = 1 + min;
            } else {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
}
