class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || stack.size()>0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            curr = curr.right;
        }
        return curr.val;
    }
}

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
    }
}

