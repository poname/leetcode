// sorting
// time: O(nlog(n))
// space: O(sort space) -> O(1) or O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int[] t : intervals) {
            int[] base = merged.get(merged.size()-1);
            if (t[0] <= base[1]) {
                base[1] = Math.max(base[1], t[1]);
            } else {
                merged.add(t);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] curr = null;
        for (int[] ival : intervals) {
            if (curr == null) {
                curr = ival;
            } else {
                if (curr[1] < ival[0]) {
                    res.add(curr);
                    curr = ival;
                } else {
                    curr[0] = Math.min(curr[0], ival[0]);
                    curr[1] = Math.max(curr[1], ival[1]);
                }
            }
        }
        if (curr != null) {
            res.add(curr);
        }
        return res.toArray(new int[0][2]);
    }
}
