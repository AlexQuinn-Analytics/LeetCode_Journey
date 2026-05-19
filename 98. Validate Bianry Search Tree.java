class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        return dfs (root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs (TreeNode root, long lower, long upper){
        if (root==null) return true;
        if (root.val>=upper||root.val<=lower) return false;
        return dfs(root.left, lower, root.val)&&dfs(root.right, root.val, upper);
    }
    
}