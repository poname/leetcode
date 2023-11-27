class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int duration = 0;
        if (fresh == 0) {
            return duration;
        }
        while (q.size()>0) {
            if (fresh == 0) {
                return duration;
            }
            int curLen = q.size();
            for (int k=0; k<curLen; k++) {
                int[] top = q.remove();
                int i = top[0];
                int j = top[1];
                if (i>0 && grid[i-1][j]==1) {
                    grid[i-1][j] = 2;
                    q.add(new int[]{i-1, j});
                    fresh--;
                }
                if (i<m-1 && grid[i+1][j]==1) {
                    grid[i+1][j] = 2;
                    q.add(new int[]{i+1, j});
                    fresh--;
                }
                if (j>0 && grid[i][j-1]==1) {
                    grid[i][j-1] = 2;
                    q.add(new int[]{i, j-1});
                    fresh--;
                }
                if (j<n-1 && grid[i][j+1]==1) {
                    grid[i][j+1] = 2;
                    q.add(new int[]{i, j+1});
                    fresh--;
                }
            }
            duration++;
        }
        return -1;
    }
}
