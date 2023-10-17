

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        rec(1, n, k, cur, ans);
        return ans;
    }

    private void rec(int i, int n, int k, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (i > n) {
            return;
        }
        cur.add(i);
        rec(i+1, n, k, cur, ans);
        cur.remove(cur.size()-1);
        rec(i+1, n, k, cur, ans);
    }
}
