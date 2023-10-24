class Solution {
    public int search(int[] nums, int target) {
        return bst(0, nums.length-1, target, nums);
    }
    
    private int bst(int start, int end, int target, int[] nums) {
        if (start > end) {
            return -1;
        }
        int mid = (start+end) / 2;
        if (target < nums[mid]) {
            return bst(start, mid-1, target, nums);
        } else if (target > nums[mid]) {
            return bst(mid+1, end, target, nums);
        } else {
            return mid;
        }
    }
}
