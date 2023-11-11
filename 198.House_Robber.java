class Solution {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int n : nums) {
            int c = Math.max(b, a + n);
            a = b;
            b = c;
        }
        return b;
    }
}

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for (int i=2; i<n; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[n-1];
    }
}
