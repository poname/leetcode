class Solution {
    public int findMin(int[] nums) {
        return minbst(0, nums.length-1, nums);
    }
    int minbst(int l, int r, int[] nums) {
        if (nums[l] > nums[r]) {
            int m = (l+r)/2;
            if (nums[m] > nums[r]) {
                return minbst(m+1, r, nums);
            } else {
                return minbst(l, m, nums);
            }
        } else {
            return nums[l];
        }
    }
}
