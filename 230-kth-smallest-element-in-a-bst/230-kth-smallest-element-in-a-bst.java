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
    PriorityQueue<Integer> maxHeap;
    
    public int kthSmallest(TreeNode root, int k) {
        maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        size = k;
        traversal(root);
        return maxHeap.poll();
    }
    
    public void traversal(TreeNode node) {
        if (node == null) return;
        maxHeap.add(node.val);
        if (maxHeap.size() > size) {
            maxHeap.poll();
        }
        traversal(node.left);
        traversal(node.right);
        return;
    }
}