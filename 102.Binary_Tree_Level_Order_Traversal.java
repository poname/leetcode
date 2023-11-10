class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<> ();
        if (root != null) {
            queue.add(root);
        }
        
        while (queue.size() > 0) {
            List<Integer> level = new ArrayList<>();
            final int num = queue.size();
            for (int i=0; i<num; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}

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
