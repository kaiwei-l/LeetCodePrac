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
    public boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) return true;
        return false;
    }
    
    public void addLeaves(TreeNode node, List<Integer> list) {
        if (isLeaf(node)) list.add(node.val);
        if (node.left != null) {
            addLeaves(node.left, list);
        }
        if (node.right != null) {
            addLeaves(node.right, list);
        }
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBoundary = new ArrayList<>();
        List<Integer> rightBoundary = new ArrayList<>();
        List<Integer> leaf = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        if (root == null) {
            return ans;
        }
        
        if (!isLeaf(root)) {
            ans.add(root.val);
        }
        // Looking for left
        if (root.left != null) {
            stack.add(root.left);
            while (!stack.isEmpty()) {
                TreeNode node = stack.removeLast();
                if (!isLeaf(node)) {
                    leftBoundary.add(node.val);
                }
                if (node.left != null) {
                    stack.add(node.left);
                } else if (node.left == null && node.right != null) {
                    stack.add(node.right);
                }
            }
        }
        
        // Looking for right
        if (root.right != null) {
            stack.add(root.right);
            while (!stack.isEmpty()) {
                TreeNode node = stack.removeLast();
                if (!isLeaf(node)) {
                    rightBoundary.add(node.val);
                }
                if (node.right != null) {
                    stack.add(node.right);
                } else if (node.right == null && node.left != null) {
                    stack.add(node.left);
                }
            }
        }
        
        // looking for leaves
        addLeaves(root, leaf);
        
        Collections.reverse(rightBoundary);
        ans.addAll(leftBoundary);
        ans.addAll(leaf);
        ans.addAll(rightBoundary);
        return ans;
    }
}


