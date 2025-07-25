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

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for (int[] iv : intervals) {
            if (iv[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], iv[1]);
            } else {
                merged.add(prev);
                prev = iv;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<int[]> minH = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<int[]> merged = new ArrayList<>();
        for (int[] iv : intervals) {
            while (minH.size() > 0 && minH.peek()[1] < iv[0]) {
                merged.add(minH.poll());
            }
            if (minH.size() == 0)
                minH.add(iv);
            else
                minH.peek()[1] = Math.max(iv[1], minH.peek()[1]);
        }
        merged.add(minH.poll());
        return merged.toArray(new int[merged.size()][]);
    }
}

// sweep line - tree map
// time: O(nlog(n))
// space: O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] iv : intervals) {
            map.put(iv[0], map.getOrDefault(iv[0], 0) + 1);
            map.put(iv[1], map.getOrDefault(iv[1], 0) - 1);
        }
        List<int[]> merged = new ArrayList<>();
        int have = 0;
        int start = -1;
        for (int point : map.keySet()) {
            if (have == 0) {
                start = point; // point is the start of the interval
            }
            have += map.get(point);
            if (have == 0) {
                merged.add(new int[] { start, point }); // point is the end of the interval
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
// [2, 6] [1, 3] [8, 10]
// tree map:
// k  -->  v
// 1  -->  1
// 2  -->  1
// 3  --> -1
// 6  --> -1
// 8  -->  1
// 10 --> -1
// have += mp.get(k):
// ..... 1 ..... 2 ..... 3 ..... 6 ..... 8 ..... 10
// 00000 1 11111 2 22222 1 11111 0 00000 1 11111 0
//       |----------------------->       |------->
// | have toggaling from 0 to 1 is the start of an interval
// - the interval continues while have is greater than 0
// > have toggling from 1 to 1 is the end of an interval
 
