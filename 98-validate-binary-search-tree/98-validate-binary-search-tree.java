/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return bstAux(root, null, null);
    }
    
    public boolean bstAux(TreeNode node, Integer lo, Integer hi) {
        if (node == null) return true;
        if (lo != null && lo >= node.val) return false;
        if (hi != null && hi <= node.val) return false;
        return bstAux(node.left, lo, node.val) && bstAux(node.right, node.val, hi);
    }
}