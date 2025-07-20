// time: O(n * mlog(m))
// space: O(n * m)
// n: number of strings, m: length of the longest string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sorted = sort(s);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
    private String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c); 
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] in = s.toCharArray();
            Arrays.sort(in);
            String key = new String(in);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

// time: O(n * m)
// space: O(n * m)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sig = sign(s);
            map.putIfAbsent(sig, new ArrayList<>());
            map.get(sig).add(s);
        }
        return new ArrayList<>(map.values());
    }
    String sign(String in) {
        int[] count = new int[26];
        for (char c : in.toCharArray()) {
            count[c-'a']++;
        }
        return Arrays.toString(count);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] in = new int[26];
            for (char c : s.toCharArray()) {
                in[c - 'a']++;
            }
            String key = Arrays.toString(in);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
