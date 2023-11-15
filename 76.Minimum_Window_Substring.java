class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        for (Character c : t.toCharArray()) {
            need.putIfAbsent(c, 0);
            have.putIfAbsent(c, 0);
            need.computeIfPresent(c, (k,v) -> v+1);
        }

        int sat = 0; // satisfied constraints
        
        char[] in = s.toCharArray();
        int minLen = in.length+1;
        int minStart = -1;
        int l = 0;
        for (int r=0; r<in.length; r++) {
            have.computeIfPresent(in[r], (k,v) -> v+1);
            if (need.containsKey(in[r]) && have.get(in[r]).equals(need.get(in[r]))) {
                sat++;
            }
            while (sat==need.size()) {
                if (r-l+1 < minLen) {
                    minLen = r-l+1;
                    minStart = l;
                }
                if (need.containsKey(in[l]) && have.get(in[l]).equals(need.get(in[l]))) {
                    sat--;
                }
                have.computeIfPresent(in[l], (k,v) -> v-1);
                l++;
            }
        }
        if (minStart < 0) {
            return "";
        } else {
            return s.substring(minStart, minStart+minLen);
        }
    }
}

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.putIfAbsent(c, 0);
            have.putIfAbsent(c, 0);
            need.computeIfPresent(c, (k,v) -> v+1);
        }
        
        char[] in = s.toCharArray();
        int minLen = in.length+1;
        int minStart = -1;
        int l = 0;
        for (int r=0; r<in.length; r++) {
            have.computeIfPresent(in[r], (k,v) -> v+1);
            while (isValid(need, have)) {
                if (r-l+1 < minLen) {
                    minLen = r-l+1;
                    minStart = l;
                }
                have.computeIfPresent(in[l], (k,v) -> v-1);
                l++;
            }
        }
        if (minStart < 0) {
            return "";
        } else {
            return s.substring(minStart, minStart+minLen);
        }
    }
    boolean isValid(Map<Character, Integer> need, Map<Character, Integer> have) {
        for (Character c : need.keySet()) {
            if (have.get(c) < need.get(c)) {
                return false;
            }
        }
        return true;
    }
}
