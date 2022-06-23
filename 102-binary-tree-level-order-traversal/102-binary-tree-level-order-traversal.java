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
    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode nullNode = new TreeNode(1001);
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.removeFirst();
                if (n.val != 1001) {
                    temp.add(n.val);
                    if (n.left == null) {
                        q.addLast(nullNode);
                    } else {
                        q.addLast(n.left);
                    }
                    if (n.right == null) {
                        q.addLast(nullNode);
                    } else {
                        q.addLast(n.right);
                    }
                }
            }
            if (temp.size() != 0) ans.add(temp);
        }
        return ans;
    }
}