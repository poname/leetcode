class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int k=0; k<9; k++) {
            if (!check(k, k, 0, 8, board) || !check(0, 8, k, k, board)) {
                return false;
            }
        }
        for (int i=0; i<9; i+=3) {
            for (int j=0; j<9; j+=3) {
                if (!check(i, i+2, j, j+2, board)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check(int iStart, int iEnd, int jStart, int jEnd, char[][] board) {
        int[] count = new int[9];
        for (int i=iStart; i<=iEnd; i++) {
            for (int j=jStart; j<=jEnd; j++) {
                if (board[i][j] != '.') {
                    count[board[i][j]-'1']++;
                }
            }
        }
        for (int c : count) {
            if (c > 1) {
                return false;
            }
        }
        return true;
    }
}
