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
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        // Write your code here
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval iv : intervals) {
            map.putIfAbsent(iv.start, 0);
            map.computeIfPresent(iv.start, (k,v) -> v+1);
            map.putIfAbsent(iv.end, 0);
            map.computeIfPresent(iv.end, (k,v) -> v-1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        int max = 0;
        int curr = 0;
        for (int k : keys) {
            curr += map.get(k);
            max = Math.max(max, curr);
        }
        return max;
    }
}
