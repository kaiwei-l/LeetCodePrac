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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        ans.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rightSideObtained = false;
            for (int i = 0; i < size; i++) {
                TreeNode n = q.removeFirst();
                if (n.right != null) {
                    q.addLast(n.right);
                    if (!rightSideObtained) {
                        ans.add(n.right.val);
                        rightSideObtained = true;
                    }
                }
                if (n.left != null) {
                    q.addLast(n.left);
                    if (!rightSideObtained) {
                        ans.add(n.left.val);
                        rightSideObtained = true;
                    }
                }
            }
        }
        return ans;
    }
}