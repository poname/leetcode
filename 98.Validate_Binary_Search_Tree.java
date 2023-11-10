class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }
    private boolean check(TreeNode root, Integer minV, Integer maxV) {
        if (root == null) {
            return true;
        }
        if ((minV != null && minV >= root.val) || (maxV != null && root.val >= maxV)) {
            return false;
        }
        return check(root.left, minV, root.val) && check(root.right, root.val, maxV);
    }
}
