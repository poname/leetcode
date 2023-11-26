class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 || i==m-1 || j==0 || j==n-1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] != 'C') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'C') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (i<0 || i>=m || j<0 || j>=n || board[i][j]!='O') {
            return;
        }
        board[i][j] = 'C';
        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
    }
}
