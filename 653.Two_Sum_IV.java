// 2ms
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        bst(root, arr);
        int l=0;
        int r=arr.size()-1;
        while (l<r) {
            int sum = arr.get(l) + arr.get(r);
            if (sum > k) {
                r--;
            } else if (sum < k) {
                l++;
            } else {
                return true;
            }
        }
        return false;
    }
    private void bst(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        bst(root.left, arr);
        arr.add(root.val);
        bst(root.right, arr);
    }
}

// 4ms
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        bst(root, set);
        for (int i : set) {
            if (set.contains(k-i) && k-i != i) {
                return true;
            }
        }
        return false;
    }
    private void bst(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        bst(root.left, set);
        bst(root.right, set);
    }
}
