// BFS level traversal - queue
// time: O(n)
// space: O(n)
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        map.put(root, 0);
        queue.add(root);
        int maxWidth = 0;
        while (queue.size() > 0) {
            int width = queue.size();
            int left = map.get(queue.peek());
            int right = left;
            for (int i = 0; i < width; i++) {
                TreeNode front = queue.poll();
                if (front.left != null) {
                    map.put(front.left, 2 * map.get(front));
                    queue.add(front.left);
                }
                if (front.right != null) {
                    map.put(front.right, 2 * map.get(front) + 1);
                    queue.add(front.right);
                }
                right = map.get(front);
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }
}
