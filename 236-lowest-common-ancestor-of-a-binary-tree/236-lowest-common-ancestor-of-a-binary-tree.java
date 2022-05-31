/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lwa(root, p, q);
        return ans;
    }
    
    public boolean lwa(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int left = (lwa(root.left, p, q) == true) ? 1 : 0;
        int right = (lwa(root.right, p, q) == true) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) ans = root;
        return (left + right + mid > 0);
    }
}