class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        rec(0, target, candidates, cur, ans);
        return ans;
    }

    private void rec(int i, int target, int[] nums, List<Integer> cur, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || i == nums.length) {
            return;
        }
        cur.add(nums[i]);
        rec(i, target-nums[i], nums, cur, ans);
        cur.remove(cur.size()-1);
        rec(i+1, target, nums, cur, ans);
    }
}
