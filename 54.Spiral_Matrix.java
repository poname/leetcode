class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int l=0;
        int r=matrix[0].length;
        int t=0;
        int b=matrix.length;
        while (l<r && t<b) {
            for (int j=l; j<r; j++) {
                res.add(matrix[t][j]);
            }
            t++;
            if (!(t<b)) {
                break;
            }
            for (int i=t; i<b; i++) {
                res.add(matrix[i][r-1]);
            }
            r--;
            if (!(l<r)) {
                break;
            }
            for (int j=r-1; j>=l; j--) {
                res.add(matrix[b-1][j]);
            }
            b--;
            // if (!(t<b)) {
            //     break;
            // }
            for (int i=b-1; i>=t; i--) {
                res.add(matrix[i][l]);
            }
            l++;
            // if (!(l<r)) {
            //     break;
            // }
        }
        return res;
    }
}
