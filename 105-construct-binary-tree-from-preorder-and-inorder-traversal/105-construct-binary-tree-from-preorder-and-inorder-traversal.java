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
    private int preIndx = 0;
    private int size;
    private int[] preOrder;
    private int[] inOrder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        size = preorder.length;
        HashMap<Integer, Integer> preToIn = new HashMap<>();
        for (int i = 0; i < size; i++) {
            preToIn.put(inorder[i], i);
        }
        
        TreeNode ans = buildAux(preToIn, 0, size - 1);
        return ans;
    }
    
    public TreeNode buildAux(HashMap<Integer, Integer> preToIn, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preOrder[preIndx]);
        preIndx++;
        int inOrderIndx = preToIn.get(node.val);
        node.left = buildAux(preToIn, left, inOrderIndx - 1);
        node.right = buildAux(preToIn, inOrderIndx + 1, right);
        return node;
    }
}