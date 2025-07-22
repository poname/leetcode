// time: O(n)
// space: O(n)

// DFS - recusrsion
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// DFS - Stack
class Solution {
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        if (root != null) {
            stack.push(new Pair(root, 1));
        }
        int max = 0;
        while (stack.size() > 0) {
            Pair<TreeNode, Integer> top = stack.pop();
            max = Math.max(max, top.value);
            if (top.key.right != null) {
                stack.push(new Pair(top.key.right, top.value + 1));
            }
            if (top.key.left != null) {
                stack.push(new Pair(top.key.left, top.value + 1));
            }
        }
        return max;
    }
}

public class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

// BFS - Queue
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        int depth = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return depth;
    }
}
