// 3 pass
// time: O(n^2)
// space: O(1)
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

// 3 pass
// time: O(n^2)
// space: O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r=0; r<9; r++) {
            int[] count = new int[10];
            for (int c=0; c<9; c++) {
                char m = board[r][c];
                if (m != '.') {
                    if (count[m-'0'] > 0) return false;
                    count[m-'0']++;
                }
            }
        }
        for (int c=0; c<9; c++) {
            int[] count = new int[10];
            for (int r=0; r<9; r++) {
                char m = board[r][c];
                if (m != '.') {
                    if (count[m-'0'] > 0) return false;
                    count[m-'0']++;
                }
            }
        }
        for (int x=0; x<3; x++) {
            for (int y=0; y<3; y++) {
                int[] count = new int[10];
                for (int r=3*x; r<3*x+3; r++) {
                    for (int c=3*y; c<3*y+3; c++) {
                        char m = board[r][c];
                        if (m != '.') {
                            if (count[m-'0'] > 0) return false;
                            count[m-'0']++;
                        }
                    }
                }
            }
        }
        return true;
    }
}

// 1 pass
// time: O(n^2)
// space: O(n^2)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char m = board[i][j];
                if(m != '.') {
                    if(!seen.add(m+"r"+i) || !seen.add(m+"c"+j) || !seen.add(m+"s"+(i/3)+(j/3))) return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] qube = new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int m = board[r][c] - '1';
                    int q = (r / 3) * 3 + (c / 3);
                    if (rows[r][m]++ > 0 || cols[c][m]++ > 0 || qube[q][m]++ > 0)
                        return false;
                }
            }
        }
        return true;
    }
}
