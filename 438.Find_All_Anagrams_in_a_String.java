// time: O(n)
// space: O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0;
        int[] sC = new int[26];
        int[] pC = new int[26];
        List<Integer> out = new ArrayList<>();
        for (char c : p.toCharArray())
            pC[c - 'a']++;
        for (int r = 0; r < s.length(); r++) {
            sC[s.charAt(r) - 'a']++;
            if (r - l + 1 == p.length()) {
                boolean eq = true;
                for (int i = 0; i < 26; i++) {
                    if (sC[i] != pC[i])
                        eq = false;
                }
                if (eq)
                    out.add(l);
                sC[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return out;
    }
}
