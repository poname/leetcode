class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean added = false;
        for (int[] ival : intervals) {
            if (added) {
                res.add(ival);
                continue;
            } 
            if(newInterval[1] < ival[0]) {
                res.add(newInterval);
                res.add(ival);
                added = true;
            } else if (newInterval[0] > ival[1]) {
                res.add(ival);
            } else {
                newInterval[0] = Math.min(newInterval[0], ival[0]);
                newInterval[1] = Math.max(newInterval[1], ival[1]);
            }
        }
        if (!added) {
            res.add(newInterval);
        }
        return res.toArray(new int[0][2]);
    }
}
