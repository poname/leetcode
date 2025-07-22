// BFS - Queue
// time: O(n)
// space: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null)
            return out;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (level.size() > 0)
                out.add(level);
        }
        return out;
    }
}

// DFS - recursive
// time: O(n)
// space: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        dfs(root, out, 0);
        return out;
    }

    void dfs(TreeNode node, List<List<Integer>> out, int depth) {
        if (node == null)
            return;
        if (out.size() == depth)
            out.add(new ArrayList<>());
        out.get(depth).add(node.val);
        dfs(node.left, out, depth + 1);
        dfs(node.right, out, depth + 1);
    }
}
