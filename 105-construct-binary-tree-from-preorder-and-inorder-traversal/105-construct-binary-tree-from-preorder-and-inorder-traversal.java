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
    int preIndx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderIndx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndx.put(inorder[i], i);
        }
        return buildAux(preorder, inorder, inorderIndx, 0, inorder.length - 1);
    }
    
    public TreeNode buildAux(int[] preorder, int[] inorder, HashMap<Integer, Integer> inorderIndx, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndx];
        int inIndx = inorderIndx.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        preIndx++;
        root.left = buildAux(preorder, inorder, inorderIndx, left, inIndx - 1);
        root.right = buildAux(preorder, inorder, inorderIndx, inIndx + 1, right);
        return root;
    }
}