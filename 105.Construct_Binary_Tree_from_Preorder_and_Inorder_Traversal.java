class Solution {
    Map<Integer, Integer> map;
    int pC = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1, preorder);
    }

    public TreeNode build(int l, int r, int[] preorder) {
        if (l > r) {
            return null;
        }
        int rootVal = preorder[pC];
        int mid = map.get(rootVal);
        pC++;
        TreeNode left = build(l, mid - 1, preorder);
        TreeNode right = build(mid + 1, r, preorder);
        return new TreeNode(rootVal, left, right);
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
    }
    TreeNode build(int pS, int pE, int iS, int iE, int[] preorder, int[] inorder) {
        if (pS > pE || iS>iE) {
            return null;
        }
        int i=-1;
        int target = preorder[pS];
        for (i=iS; i<=iE; i++) {
            if (inorder[i] == target) {
                break;
            }
        }
        int len = i-iS;
        return new TreeNode(preorder[pS], 
            build(pS+1, pS+len, iS, iS+len-1, preorder, inorder), 
            build(pS+len+1, pE, iS+len+1, iE, preorder, inorder)
        );
    }
}
