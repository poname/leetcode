class Solution {
    public int search(int[] nums, int target) {
        int k = 0;
        int n = nums.length;
        for (int b = n / 2; b >= 1; b /= 2) {
            while (b + k < n && nums[b + k] <= target)
                k += b;
        }
        return nums[k] == target ? k : -1;
    }
}

// iterative
// time: O(logn)
// space: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while (l <= r) {
            int m = (l+r)/2;
            if (target == nums[m]) return m;
            else if (target < nums[m]) r=m-1;
            else l = m+1;
        }
        return -1;
    }
}

// recurive
class Solution {
    public int search(int[] nums, int target) {
        return dfs(0, nums.length-1, nums, target);
    }
    int dfs(int start, int end, int[] nums, int target) {
        if (start > end) return -1;
        int mid = (start+end)/2;
        if (nums[mid] == target) return mid;
        return (nums[mid]<target) ? dfs(mid+1, end, nums, target) : dfs(start, mid-1, nums, target);
    }
}
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
