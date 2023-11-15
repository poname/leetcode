class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l = 0;
        int r = n-1;
        while (l<r) {
            for (int i=0; i<r-l; i++) {
                int top = l;
                int bottom = r;

                // save top left
                int topLeft = matrix[top][l + i];

                // move bottom left to top left
                matrix[top][l + i] = matrix[bottom - i][l];

                // move borrom right to bottom left
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // move top right to bottom right
                matrix[bottom][r - i] = matrix[top + i][r];

                // move top left tp top right
                matrix[top + i][r] = topLeft; 
            }
            l++;
            r--;
        }
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
      // mirror vertically
        for (int i=0; i<n; i++) {
            for (int j=0; j<n/2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = t;
            }
        }
    }
}
