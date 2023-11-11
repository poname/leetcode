class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (grid[r][c]=='1' && !visited[r][c]) {
                    islands++;
                    dfs(r, c, visited, grid);
                }
            }
        }
        return islands;
    }
    private void dfs(int r, int c, boolean[][] visited, char[][] grid) {
        if (r<0 || r>=grid.length || c<0 || c>= grid[0].length || visited[r][c] || grid[r][c]=='0') {
            return;
        }
        visited[r][c] = true;
        dfs(r+1, c, visited, grid);
        dfs(r-1, c, visited, grid);
        dfs(r, c+1, visited, grid);
        dfs(r, c-1, visited, grid);
    }
}
