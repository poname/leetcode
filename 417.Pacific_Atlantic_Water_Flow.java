class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int c=0; c<cols; c++) {
            dfs(0, c, 0, heights, pacific);
            dfs(rows-1, c, 0, heights, atlantic);
        } 
        for (int r=0; r<rows; r++) {
            dfs(r, 0, 0, heights, pacific);
            dfs(r, cols-1, 0, heights, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }
    private void dfs(int r, int c, int prevH, int[][] heights, boolean[][] visited) {
        if (r<0 || r>=heights.length || c<0 || c>=heights[0].length || visited[r][c] || prevH>heights[r][c]) {
            return;
        }
        visited[r][c] = true;
        dfs(r+1, c, heights[r][c], heights, visited);
        dfs(r-1, c, heights[r][c], heights, visited);
        dfs(r, c+1, heights[r][c], heights, visited);
        dfs(r, c-1, heights[r][c], heights, visited);
    }
}
