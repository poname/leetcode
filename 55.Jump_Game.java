class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxSoFar = 0;
        for (int i=0; i<n; i++) {
            if (maxSoFar < i) {
                return false;
            }
            maxSoFar = Math.max(i+nums[i], maxSoFar);
        }
        return true;
    }
}
