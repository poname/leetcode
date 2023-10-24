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
