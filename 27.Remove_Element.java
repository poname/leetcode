// two pointers
// time: O(n)
// space: O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == val) {
                continue;
            }
            nums[l] = nums[r];
            l++;
        }
        return l;
    }
}
