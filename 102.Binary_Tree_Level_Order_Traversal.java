class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        rec(root, 1, res);
        return res;
    }
    private void rec(TreeNode root, int level, List<List<Integer>> traversal) {
        if (root == null) {
            return;
        }
        if (level > traversal.size()) {
            traversal.add(new ArrayList<>());
        }
        traversal.get(level-1).add(root.val);
        rec(root.left, level+1, traversal);
        rec(root.right, level+1, traversal);
    }
}
