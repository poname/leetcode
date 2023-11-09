class Solution {
    public int search(int[] nums, int target) {
        int minIdx = pivot(nums, 0, nums.length-1);
        return Math.max(
            bst(nums, minIdx, nums.length-1, target),
            bst(nums, 0, minIdx-1, target)
            );
    }
    int pivot(int[] nums, int start, int end) {
        int mid = (start+end)/2;
        if (nums[start] > nums[end]) {
            if (nums[mid] >= nums[start]) {
                return pivot(nums, mid+1, end);
            } else {
                return pivot(nums, start, mid);
            }
        } else {
            return start;
        }
    }
    int bst(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start+end)/2;
        if (nums[mid]>target) {
            return bst(nums, start, mid-1, target);
        } else if (nums[mid]<target) {
            return bst(nums, mid+1, end, target);
        } else {
            return mid;
        }
    }
}
