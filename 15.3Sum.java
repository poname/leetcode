// time: O(n^2)
// space: O(n)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        // [a, b, c]
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) // a is unique
                continue;
            if (nums[i] > 0) // skip positive a since array is sorted
                break;
            int l = i + 1, r = nums.length - 1;
            int target = -1 * nums[i];
            while (l < r) {
                int s = nums[l] + nums[r];
                if (s > target)
                    r--;
                else if (s < target)
                    l++;
                else {
                    out.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < r && nums[l - 1] == nums[l]) // b is unique
                        l++;
                }
            }
        }
        return out;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int l = i + 1;
            int r = nums.length - 1;
            int target = -1 * nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target)
                    r--;
                else if (sum < target)
                    l++;
                else {
                    out.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l<nums.length && nums[l-1]==nums[l]) l++;
                    while (r>=0 && nums[r]==nums[r+1]) r--;
                }
            }
        }
        return out;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k) {
                int tsum = nums[i]+nums[j]+nums[k];
                if (tsum<0) {
                    j++;
                } else if (tsum>0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while (j<k && nums[j]==nums[j-1]) {
                        j++;
                    }
                    /** either or both can be used
                    k--;
                    while (j<k && nums[k]==nums[k+1]) {
                        k--;
                    }
                     */
                }
            }
        }
        return ans;
    }
}
