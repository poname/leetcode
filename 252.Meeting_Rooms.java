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

// time: O(nlog(n))
// space: O(n)
public class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        int prevEnd = 0;
        for (Interval iv : intervals) {
            if (iv.start < prevEnd) {
                return false;
            }
            prevEnd = iv.end;
        }
        return true;
    }
}
