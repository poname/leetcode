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
