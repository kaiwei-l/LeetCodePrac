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
    int size;
    ArrayList<Integer> arr;
    
    public int kthSmallest(TreeNode root, int k) {
        arr = new ArrayList<>();
        size = k;
        traversal(root);
        return arr.get(k - 1);
    }
    
    public void traversal(TreeNode node) {
        if (node == null) return;
        if (arr.size() == size) return;
        traversal(node.left);
        arr.add(node.val);
        traversal(node.right);
        return;
    }
}