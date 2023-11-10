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
