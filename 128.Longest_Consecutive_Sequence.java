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
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, false);
        }
        int max = 0;
        for (int n : nums) {
            if (!map.get(n)) {
                int count = 1;
                map.put(n, true);
                int left = n-1;
                while (map.containsKey(left)) {
                    map.put(left, true);
                    count++;
                    left--;
                }
                int right = n+1;
                while (map.containsKey(right)) {
                    map.put(right, true);
                    count++;
                    right++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
