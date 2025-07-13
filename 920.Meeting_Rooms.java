// time: O(nlog(n))
// space: O(1)

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
        intervals.sort((a, b) -> a.start - b.start);
        Interval prev = new Interval(0, 0);
        for (Interval iv : intervals) {
            if (iv.start < prev.end) {
                return false;
            }
            prev = iv;
        }
        return true;
    }
}
