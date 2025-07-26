// Kadane - greedy
// time: O(n)
// space: O(1)
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
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int n : nums) {
            if (sum < 0) { // start a new array from n
                sum = 0;
            }
            sum += n;
            max = Math.max(max, sum);
        }
        return max;
    }
}
