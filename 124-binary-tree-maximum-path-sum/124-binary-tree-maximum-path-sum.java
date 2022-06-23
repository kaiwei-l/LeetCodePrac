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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        getMax(root);
        return ans;
    }
    
    public int getMax(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(getMax(node.left), 0);
        int right = Math.max(getMax(node.right), 0);
        ans = Math.max(ans, left + right + node.val);
        return node.val + Math.max(left, right);
    }
}