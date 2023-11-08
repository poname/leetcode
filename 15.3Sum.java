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
