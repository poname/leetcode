// time: O(n)
// space: O(1)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l=0;
        char[] ss = s.toCharArray();
        int len = 0;
        int maxFreq = 0;
        for (int r=0; r<ss.length; r++) {
            count[ss[r]-'A']++;
            maxFreq = Math.max(maxFreq, count[ss[r]-'A']);
            while (r-l+1-maxFreq > k) {
                count[ss[l]-'A']--;
                l++;
            }
            len = Math.max(len, r-l+1);
        }
        return len;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l=0;
        char[] ss = s.toCharArray();
        int len = 0;
        for (int r=0; r<ss.length; r++) {
            count[ss[r]-'A']++;
            while (r-l+1-getMax(count) > k) {
                count[ss[l]-'A']--;
                l++;
            }
            len = Math.max(len, r-l+1);
        }
        return len;
    }
    private int getMax(int[] count) {
        int max = count[0];
        for (int i : count) {
            max = Math.max(max, i);
        }
        return max;
    }
}
