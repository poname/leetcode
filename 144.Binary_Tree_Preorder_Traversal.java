class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || stack.size()>0) {
            if (cur == null) {
                cur = stack.pop();
            }

            output.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            cur = cur.left;
        }

        return output;
    }
}
