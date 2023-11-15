/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // [nodeId:nodeVal:leftId:rightId, ...]
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        int id=0;
        Map<TreeNode, Integer> nodes = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode top = stack.pop();
            nodes.put(top, id);
            id++;
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
    
        StringBuilder sb = new StringBuilder();
        for (TreeNode node : nodes.keySet()) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            Integer key = nodes.get(node);
            sb.append(key);
            sb.append(":");
            sb.append(node.val);
            sb.append(":");
            sb.append(nodes.get(node.left));
            sb.append(":");
            sb.append(nodes.get(node.right));
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String [] split = data.split(",");
        Map<String, TreeNode> map = new HashMap<>();
        for (String rec : split) {
            String [] values = rec.split(":");
            String nodeId = values[0];
            String nodeVal = values[1];
            String leftId = values[2];
            String rightId = values[3];
            map.putIfAbsent(nodeId, new TreeNode());
            TreeNode node = map.get(nodeId);
            node.val = Integer.valueOf(nodeVal);
            if (!leftId.equals("null")) {
                map.putIfAbsent(leftId, new TreeNode());
                node.left = map.get(leftId);
            }
            if (!rightId.equals("null")) {
                map.putIfAbsent(rightId, new TreeNode());
                node.right = map.get(rightId);
            }
        }
        return map.get("0");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
