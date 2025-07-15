// time: O(n)
// space: O(n)
// note: swap and add/push/call order doesn't matter

// DFS - recursive
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}

// BFS - queue
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode front = queue.poll();
            if (front != null) {
                TreeNode temp = front.left;
                front.left = front.right;
                front.right = temp;
                queue.add(front.left);
                queue.add(front.right);
            }
        }
        return root;
    }
}

// iterative DFS - stack
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode top = stack.pop();
            if (top != null) {
                TreeNode temp = top.left;
                top.left = top.right;
                top.right = temp;
                stack.push(top.left);
                stack.push(top.right);
            }
        }
        return root;
    }
}
