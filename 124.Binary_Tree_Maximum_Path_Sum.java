// time: O(n)
// space: O(n)
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxL = Math.max(0, dfs(root.left));
        int maxR = Math.max(0, dfs(root.right));
        max = Math.max(max, maxL + root.val + maxR);
        return root.val + Math.max(maxL, maxR);
    }
}

class Solution {
    
    public int maxPathSum(TreeNode root) {
        int[] res = new int[] {root.val};
        dfs(root, res);
        return res[0];
    }

    int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left, res));
        int rightMax = Math.max(0, dfs(root.right, res));
        res[0] = Math.max(res[0], leftMax+rightMax+root.val);
        return root.val + Math.max(leftMax, rightMax);
    }
}

// time: O(n^2)
// space: O(n)
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int here = Math.max(0, dfs(root.left)) + Math.max(0, dfs(root.right)) + root.val;
        return Math.max(here, Math.max(maxPathSum(root.left), maxPathSum(root.right)));
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return root.val + Math.max(0, Math.max(dfs(root.left), dfs(root.right)));
    }
}
