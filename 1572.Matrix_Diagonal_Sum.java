// time: O(n)
// space: O(1)
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int d=0; d<n; d++) {
            sum += mat[d][d];
            sum += mat[d][n-1-d];
        }
        if (n % 2 == 1) {
            sum -= mat[n/2][n/2];
        }
        return sum;
    }
}
