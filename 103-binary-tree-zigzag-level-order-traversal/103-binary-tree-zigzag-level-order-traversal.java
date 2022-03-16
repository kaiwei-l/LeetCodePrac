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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        TreeNode nullNode = new TreeNode(-101, null, null);
        boolean left = true;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        ArrayList<Integer> level = new ArrayList<>();
        q.add(root);
        q.add(nullNode);
        while (!q.isEmpty()) {
            TreeNode node = q.removeFirst();
            if (node.val != -101) {
                if (left) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else {
                ans.add(level);
                level = new ArrayList<Integer>();
                if (!q.isEmpty()) {
                    q.add(nullNode);
                }
                left = !left;
            }
        }
        return ans;
    }
}