// time: O(n)
// space: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[] {map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);  
        }
        
        return new int[2];
    }
}

// time: O(nlogn)
// space: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] input = new int[nums.length][2];
        for (int i=0; i<nums.length; i++) {
            input[i][0] = nums[i];
            input[i][1] = i;
        }
        Arrays.sort(input, (a, b) -> a[0]-b[0]);
        int l=0, r=nums.length-1;
        while (l < r) {
            int sum = input[l][0] + input[r][0];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{input[l][1], input[r][1]};
    }
}

// time: O(n^2)
// space: O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
