// parallel DFS
// time: O(n)
// space: O(h)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p != null && q != null) {
            return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        
        return false;
    }
}

// parallel BFS
// time: O(n)
// space: O(n)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(p);
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(q);
        while (pq.size() > 0 && qq.size() > 0) {
            TreeNode pf = pq.poll();
            TreeNode qf = qq.poll();
            if (pf == null && qf == null)
                continue;
            if (pf == null || qf == null || pf.val != qf.val)
                return false;
            pq.add(pf.left);
            pq.add(pf.right);
            qq.add(qf.left);
            qq.add(qf.right);
        }
        return pq.size() == qq.size();
    }
}
