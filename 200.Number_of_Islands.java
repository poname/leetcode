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
                //    bfs(r, c, visited, grid);
                   dfs(r, c, visited, grid);
                }
            }
        }
        return islands;
    }
    private void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, col});
        while (queue.size() > 0) {
            Integer[] top = queue.remove();
            int r = top[0];
            int c = top[1];
            if (r<0 || r>=grid.length || c<0 || c>= grid[0].length || visited[r][c] || grid[r][c]=='0') {
                continue;
            }
            visited[r][c] = true;
            queue.add(new Integer[]{r+1, c});
            queue.add(new Integer[]{r-1, c});
            queue.add(new Integer[]{r, c+1});
            queue.add(new Integer[]{r, c-1});
        }
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
