class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return rec(0, nums);
    }

    private List<List<Integer>> rec(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> empty = new ArrayList<>();
            empty.add(new ArrayList<>());
            return empty;
        }
        List<List<Integer>> after = rec(i+1, nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> a : after) {
            for (int j=0; j<=a.size(); j++) {
                List<Integer> aClone = new ArrayList<>(a);
                aClone.add(j, nums[i]);
                ans.add(aClone);
            }
        }
        return ans;
    }
}
