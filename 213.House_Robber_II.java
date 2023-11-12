class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }

        // no last
        int a=0;
        int b=0;
        for (int i=0; i<n-1; i++) {
            int c = Math.max(b, a+nums[i]);
            a=b;
            b=c;
        }

        // no first
        int x=0;
        int y=0;
        for (int i=1; i<n; i++) {
            int z = Math.max(y, x+nums[i]);
            x=y;
            y=z;
        }

        return Math.max(b, y);
    }
}
