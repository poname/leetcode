class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        gen(n, n, "", out);
        return out;
    }
    private void gen(int open, int close, String pref, List<String> ans) {
        if (close == 0) {
            ans.add(pref);
            return;
        }
        if (close > open) {
            gen(open, close-1, pref+")", ans);
        }
        if (open > 0) {
            gen(open-1, close, pref+"(", ans);
        }
    }
}
