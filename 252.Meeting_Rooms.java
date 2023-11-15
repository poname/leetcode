/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        Interval[] ivals = intervals.toArray(new Interval[0]);
        Arrays.sort(ivals, (a, b) -> a.end-b.end); // sort by end values ASC
        int endSoFar = ivals[0].start; // or Integer.MIN_VALUE;
        for (Interval iv : ivals) {
            if (endSoFar <= iv.start) {
                endSoFar = iv.end;
            } else {
                return false; // overlap
            }
        }
        return true;
    }
}
