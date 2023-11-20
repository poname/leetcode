class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] have = new int[26];
        for (char c : s1.toCharArray()) {
            need[c-'a']++;
        }
        int l=0;
        char[] in = s2.toCharArray();
        for (int r=0; r<in.length; r++) {
            int len = r-l+1;
            have[in[r]-'a']++;
            if (len < s1.length()) {
                continue;
            } else {
                if (isOk(need, have)) {
                    return true;
                }
                have[in[l]-'a']--;
                l++;
            }
        }
        return false;
    }
    private boolean isOk(int[] need, int[] have) {
        for (int i=0; i<26; i++) {
            if (need[i] > have[i]) {
                return false;
            }
        }
        return true;
    }
}
