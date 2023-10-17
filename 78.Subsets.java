class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        rec(0, nums, cur, ans);
        return ans;
    }

    private void rec(int i, int[] nums, List<Integer> cur, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        rec(i+1, nums, cur, ans);
        cur.remove(cur.size()-1);
        rec(i+1, nums, cur, ans);
    }
}
