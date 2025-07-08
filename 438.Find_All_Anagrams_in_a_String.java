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

// optimized - no array compare
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0;
        int[] sC = new int[26];
        int[] pC = new int[26];
        int have = 0;
        int want = 0;
        List<Integer> out = new ArrayList<>();
        for (char c : p.toCharArray())
            pC[c - 'a']++;
        for (int x : pC)
            want += (x > 0) ? 1 : 0;
        for (int r = 0; r < s.length(); r++) {
            int iR = s.charAt(r) - 'a';
            sC[iR]++;
            if (sC[iR] == pC[iR])
                have++;
            if (r - l + 1 == p.length()) {
                if (have == want)
                    out.add(l);
                int iL = s.charAt(l) - 'a';
                if (sC[iL] == pC[iL])
                    have--;
                sC[iL]--;
                l++;
            }
        }
        return out;
    }
}
