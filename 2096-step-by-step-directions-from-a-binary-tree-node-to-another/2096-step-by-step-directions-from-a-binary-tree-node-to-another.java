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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLca(root, startValue, destValue);
        StringBuilder toStart = new StringBuilder();
        StringBuilder toEnd = new StringBuilder();
        traverse(lca, startValue, toStart);
        traverse(lca, destValue, toEnd);
        for (int i = 0; i < toStart.length(); i++) {
            toStart.setCharAt(i, 'U');
        }
        toStart.append(toEnd);
        return toStart.toString();
    }
    
    public TreeNode findLca (TreeNode root, int start, int dest) {
        if (root == null) return null;
        if (root.val == start || root.val == dest) return root;
        TreeNode left = findLca(root.left, start, dest);
        TreeNode right = findLca(root.right, start, dest);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
    
    public boolean traverse(TreeNode lca, int value, StringBuilder path) {
        if (lca == null) return false;
        if (lca.val == value) return true;
        path.append('L');
        if (traverse(lca.left, value, path)) return true;
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if (traverse(lca.right, value, path)) return true;
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
}