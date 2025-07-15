// time: O(1) for query and O(n) for constructor
// space: O(n) for constructor
class NumArray {

    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right] - ((left > 0) ? sum[left - 1] : 0);
    }
}
