class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        int overlap = 0;
        int endSoFar = intervals[0][0]; // or Integer.MIN_VALUE;
        for (int[] ival : intervals) {
            if (endSoFar <= ival[0]) {
                endSoFar = ival[1];
            } else {
                overlap++;
            }
        }
        return overlap;
    }
}
