// time: O(n)
// space: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] == nums[r - 1]) {
                continue;
            }
            l++;
            nums[l] = nums[r];
        }
        return l + 1;
    }
}
