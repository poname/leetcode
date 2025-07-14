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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        // Write your code here
        Map<Integer, Integer> map = new TreeMap<>(); // to keep the keys sorted ASC
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

// min heap
// time: O()
// space: O()
public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        Queue<Interval> minH = new PriorityQueue<>((a, b) -> a.end - b.end);
        int max = 0;
        for (Interval iv : intervals) {
            while (minH.size() > 0 && minH.peek().end <= iv.start) {
                minH.poll();
            }
            minH.add(iv);
            max = Math.max(max, minH.size());
        }
        return max;
    }
}

// two pointer - sort
// time: O(nlog(n))
// space: O(n)
public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int k=0; k<n; k++) {
            Interval iv = intervals.get(k);
            start[k] = iv.start;
            end[k] = iv.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0, j=0;
        int max = 0;
        int ov = 0;
        while (i<n && j<n) {
            if (start[i] < end[j]) {
                ov++;
                i++;
            } else {
                ov--;
                j++;
            }
            max = Math.max(max, ov);
        }
        return max;
    }
}

// greedy - sort
// time: O(nlog(n))
// space: O(n)
public class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> time = new ArrayList<>();
        for (Interval iv : intervals) {
            time.add(new int[]{iv.start, 1});
            time.add(new int[]{iv.end, -1});
        }
        time.sort((a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int ov=0;
        int max=0;
        for (int[] t : time) {
            ov += t[1];
            max = Math.max(max, ov);
        }
        return max;
    }
}
