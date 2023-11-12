class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 1;
        int res = 1;
        for (int i=n-2; i>=0; i--) {
            int max = 0;
            for (int j=i+1; j<n; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
            res = Math.max(res, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return res;
    }
}
