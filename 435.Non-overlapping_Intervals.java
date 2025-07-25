// |-----|----------|
// |----------|-----|

// Greedy - sort by end
// time: O(log(n))
// space: O(1) or O(n) depending on the sort
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prevEnd = intervals[0][0]; // or Integer.MIN_VALUE;
        int remove = 0;
        for (int[] iv : intervals) {
            if (iv[0] < prevEnd) {
                remove++;
                // prevEnd = Math.min(prevEnd, iv[1]);
            } else {
                prevEnd = iv[1];
            }
        }
        return remove;
    }
}

// Greedy - sort by start
// time: O(log(n))
// space: O(1) or O(n) depending on the sort
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prevEnd = intervals[0][0]; // or Integer.MIN_VALUE;
        int remove = 0;
        for (int[] iv : intervals) {
            if (iv[0] < prevEnd) {
                remove++;
                prevEnd = Math.min(prevEnd, iv[1]);
            } else {
                prevEnd = iv[1];
            }
        }
        return remove;
    }
}
