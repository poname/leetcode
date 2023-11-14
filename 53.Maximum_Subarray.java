class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currMax = 0;
        for (int n : nums) {
            currMax = n + Math.max(0, currMax);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
