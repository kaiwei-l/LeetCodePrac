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
        return validBSTAux(root, null, null);
    }
    
    public boolean validBSTAux(TreeNode node, Integer lo, Integer hi) {
        if (node == null) {
            return true;
        } 
        if ((lo != null && node.val <= lo) || (hi != null && node.val >= hi)) {
            return false;
        }
        return validBSTAux(node.left, lo, node.val) && validBSTAux(node.right, node.val, hi);
    }
}