// iterative - one pass
// time: O(log(m*n))
// space: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int start = 0, end = m*n-1;
        while (start <= end) {
            int mid = (start+end)/2;
            int mR = mid/n, mC = mid%n;
            if (matrix[mR][mC] == target) return true;
            else if (matrix[mR][mC] < target) start = mid+1;
            else   end = mid-1;
        }
        return false;
    }
}

// recursive - one pass
// time: O(log(m*n))
// space: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        return rec(0, m * n - 1, matrix, target);
    }

    boolean rec(int start, int end, int[][] matrix, int target) {
        if (start > end)
            return false;
        int n = matrix[0].length;
        int mid = (start + end) / 2;
        if (matrix[mid / n][mid % n] == target)
            return true;
        return (matrix[mid / n][mid % n] < target) ? rec(mid + 1, end, matrix, target)
                : rec(start, mid - 1, matrix, target);
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return bst(0, m*n-1, n, matrix, target);
    }
    private boolean bst(int start, int end, int row, int[][] matrix, int target) {
        if (start > end) {
            return false;
        }
        int mid = (start+end)/2;
        if (matrix[mid/row][mid%row]<target) {
            return bst(mid+1, end, row, matrix, target);
        } else if (matrix[mid/row][mid%row]>target) {
            return bst(start, mid-1, row, matrix, target);
        } else {
            return true;
        }
    }
}

// staircase
// time: O(m+n)
// space: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n-1;
        while (col >= 0 && row < m) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else if (matrix[row][col] < target) row++;
        }
        return false;
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = m-1, col = 0;
        while (col < n && row >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) row--;
            else if (matrix[row][col] < target) col++;
        }
        return false;
    }
}
