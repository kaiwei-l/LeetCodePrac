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
    ArrayList<Integer> inorder;
    public TreeNode balanceBST(TreeNode root) {
        inorder = new ArrayList<>();
        inorderTraversal(root);
        int n = inorder.size();
        int left = 0;
        int right = n - 1;
        return construct(left, right);
    }
    
    public TreeNode construct(int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(inorder.get(mid));
            node.left = construct(left, mid - 1);
            node.right = construct(mid + 1, right);
            return node;
        }
        return null;
    }
    
    public void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }
}