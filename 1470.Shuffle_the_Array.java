// in-place
// time: O(n)
// space: O(1)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i] += (nums[i + n] << 10);
        }
        for (int i = n - 1; i >= 0; i--) {
            nums[2 * i + 1] = (nums[i] >> 10);
            nums[2 * i] = (nums[i] & ((1 << 10) - 1));
        }
        return nums;
    }
}

class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i] += nums[i + n] * 10000;
        }
        for (int i = n - 1; i >= 0; i--) {
            nums[2 * i + 1] = nums[i] / 10000;
            nums[2 * i] = nums[i] % 10000;
        }
        return nums;
    }
}

// extra space
// time: O(n)
// space: O(n)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffle = new int[2 * n];
        for (int i = 0; i < n; i++) {
            shuffle[2 * i] = nums[i];
            shuffle[2 * i + 1] = nums[n + i];
        }
        return shuffle;
    }
}
