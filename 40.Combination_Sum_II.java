class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        cs2(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
    void cs2(int i, int[] candidates, int target, List<Integer> soFar, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(soFar));
            return;
        }
        if (i >= candidates.length || target < 0) {
            return;
        }
        soFar.add(candidates[i]);
        cs2(i+1, candidates, target-candidates[i], soFar, res);
        soFar.remove(soFar.size()-1);
        while (i+1<candidates.length && candidates[i]==candidates[i+1]) {
            i++;
        }
        cs2(i+1, candidates, target, soFar, res);
    }
}
