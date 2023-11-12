class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> deadlock = new HashSet<>();
        return check(0, s, wordDict, deadlock);
    }
    private boolean check(int idx, String s, List<String> wordDict, Set<Integer> deadlock) {
        if (s.length() == 0) {
            return true;
        }
        if (deadlock.contains(idx)) {
            return false;
        }
        for (String w : wordDict) {
            if (s.startsWith(w) && check(idx+w.length(), s.substring(w.length()), wordDict, deadlock)) {
                return true;
            }
        }
        deadlock.add(idx);
        return false;
    }
}
