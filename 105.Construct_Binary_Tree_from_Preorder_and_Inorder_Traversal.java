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
