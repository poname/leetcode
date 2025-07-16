// DFS
// time: O(n)
// space: O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}

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

// BFS
// time: O(n)
// space: O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        Map<TreeNode, Long> minMap = new HashMap<>();
        Map<TreeNode, Long> maxMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        minMap.put(root, Long.MIN_VALUE);
        maxMap.put(root, Long.MAX_VALUE);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            long min = minMap.get(node);
            long max = maxMap.get(node);
            if (node.val <= min || node.val >= max) {
                return false;
            }
            if (node.left != null) {
                queue.add(node.left);
                minMap.put(node.left, min);
                maxMap.put(node.left, (long) node.val);
            }
            if (node.right != null) {
                queue.add(node.right);
                minMap.put(node.right, (long) node.val);
                maxMap.put(node.right, max);
            }
        }
        return true;
    }
}

// brute force
// time: O(n^2)
// space: O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && max(root.left) >= root.val) {
            return false;
        }
        if (root.right != null && min(root.right) <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    int max(TreeNode root) {
        if (root.left != null && root.right != null) {
            return Math.max(root.val, Math.max(max(root.left), max(root.right)));
        }
        if (root.left != null) {
            return Math.max(root.val, max(root.left));
        }
        if (root.right != null) {
            return Math.max(root.val, max(root.right));
        }
        return root.val;
    }

    int min(TreeNode root) {
        if (root.left != null && root.right != null) {
            return Math.min(root.val, Math.min(min(root.left), min(root.right)));
        }
        if (root.left != null) {
            return Math.min(root.val, min(root.left));
        }
        if (root.right != null) {
            return Math.min(root.val, min(root.right));
        }
        return root.val;
    }
}
