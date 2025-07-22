// time: O(n)
// space: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int max = 0;
        for (int k : set) {
            if (!set.contains(k-1)) {
                int tail = k;
                while (set.contains(tail+1)) {
                    tail++;
                }
                max = Math.max(max, tail-k+1);
            }
        }
        return max;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, map.getOrDefault(n - 1, 0) + map.getOrDefault(n + 1, 0) + 1);
                map.put(n - map.getOrDefault(n - 1, 0), map.get(n));
                map.put(n + map.getOrDefault(n + 1, 0), map.get(n));
                max = Math.max(max, map.get(n));
            }
        }
        return max;
    }
}
