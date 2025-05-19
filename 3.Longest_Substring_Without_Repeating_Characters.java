// time: O(n) - n is the length of the string
// space: O(m) - m is the number of unique characters in the string
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] set = new int[128];
        int len = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set[s.charAt(r)] > 0) {
                set[s.charAt(l)]--;
                l++;
            }
            set[s.charAt(r)]++;
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r)))
                set.remove(s.charAt(l++));
            set.add(s.charAt(r));
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        char[] chars = s.toCharArray();
        int l=0;
        for (int r=0; r<chars.length; r++) {
            while (set.contains(chars[r])) {
                set.remove(chars[l]);
                l++;
            }
            set.add(chars[r]);
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
