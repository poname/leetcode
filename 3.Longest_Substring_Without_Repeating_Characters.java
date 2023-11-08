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

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        char[] chars = s.toCharArray();
        int l=0;
        for (int r=0; r<chars.length; r++) {
            if (set.contains(chars[r])) {
                while (chars[l] != chars[r]) {
                    set.remove(chars[l]);
                    l++;
                }
                l++;
            } else {
                set.add(chars[r]);
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
