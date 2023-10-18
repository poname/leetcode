class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', "abc".toCharArray());
        map.put('3', "def".toCharArray());
        map.put('4', "ghi".toCharArray());
        map.put('5', "jkl".toCharArray());
        map.put('6', "mno".toCharArray());
        map.put('7', "pqrs".toCharArray());
        map.put('8', "tuv".toCharArray());
        map.put('9', "wxyz".toCharArray());
        rec(0, digits.toCharArray(), map, "", ans);
        return ans;
    }

    private void rec(int i, char[] input, Map<Character, char[]> map, String prefix, List<String> ans) {
        if (i == input.length) {
            ans.add(prefix);
            return;
        }
        for (char c : map.get(input[i])) {
            rec(i+1, input, map, prefix+c, ans);
        }
    }
}
