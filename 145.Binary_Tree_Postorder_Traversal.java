class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        Stack<Boolean> visited = new Stack();
        visited.push(false);

        while (stack.size() > 0) {
            TreeNode top = stack.pop();
            boolean isVisited = visited.pop();

            if (top != null) {
                if (isVisited) {
                    output.add(top.val);
                } else {
                    stack.push(top);
                    visited.push(true);
                    stack.push(top.right);
                    visited.push(false);
                    stack.push(top.left);
                    visited.push(false);
                }
            }
        }

        return output;
    }
}
