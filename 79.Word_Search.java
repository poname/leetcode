// O (m * n * 4^(word.length))
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int r=0; r<rows; r++) { // O(m)
            for (int c=0; c<cols; c++) { // O(n)
                if (dfs(r, c, board, rows, cols, 0, word.toCharArray(), visited)) { // O(4^(word.length))
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int r, int c, char[][] board, final int rows, final int cols, int i, char[] word, boolean[][] visited) {
        if (i >= word.length) {
            return true;
        }
        if (r<0 || r>=rows || c<0 || c>=cols || visited[r][c] || board[r][c] != word[i]) {
            return false;
        }
        visited[r][c] = true;
        boolean res = 
                dfs (r-1, c, board, rows, cols, i+1, word, visited) ||
                dfs (r, c-1, board, rows, cols, i+1, word, visited) ||
                dfs (r+1, c, board, rows, cols, i+1, word, visited) ||
                dfs (r, c+1, board, rows, cols, i+1, word, visited);
        visited[r][c] = false;
        return res;
    }
}

// O (m * n * 4^(word.length))
class Solution {
    public boolean exist(char[][] board, String word) {
        Set<Integer> visited = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int r=0; r<rows; r++) { // O(m)
            for (int c=0; c<cols; c++) { // O(n)
                if (dfs(r, c, board, rows, cols, 0, word.toCharArray(), visited)) { // O(4^(word.length))
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int r, int c, char[][] board, final int rows, final int cols, int i, char[] word, Set<Integer> visited) {
        if (i >= word.length) {
            return true;
        }
        if (r<0 || r>=rows || c<0 || c>=cols || visited.contains(r*cols+c) || board[r][c] != word[i]) {
            return false;
        }
        visited.add(r*cols+c);
        boolean res = 
                dfs (r-1, c, board, rows, cols, i+1, word, visited) ||
                dfs (r, c-1, board, rows, cols, i+1, word, visited) ||
                dfs (r+1, c, board, rows, cols, i+1, word, visited) ||
                dfs (r, c+1, board, rows, cols, i+1, word, visited);
        visited.remove(r*cols+c);
        return res;
    }
}
