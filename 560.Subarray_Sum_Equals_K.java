// time: O(n)
// space: O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // adding a 0 to the start of nums
        int sum = 0;
        int count = 0;
        for (int n : nums) {
            sum += n;
            // sum[r] - sum[l-1] == k -> sum[l-1] = sum[r] - k
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

// time: O(n^2)
// space: O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }
}
