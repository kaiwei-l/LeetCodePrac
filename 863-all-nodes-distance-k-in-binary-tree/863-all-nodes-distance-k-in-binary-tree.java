/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, List<Integer>> adjList;
    
    public void connect(TreeNode parent, TreeNode child) {
        if (parent != null && child != null) {
            List<Integer> childList = adjList.getOrDefault(parent.val, new ArrayList<Integer>());
            List<Integer> parentList = adjList.getOrDefault(child.val, new ArrayList<Integer>());
            childList.add(child.val);
            parentList.add(parent.val);
            adjList.put(parent.val, childList);
            adjList.put(child.val, parentList);
        }
        if (child.left != null) connect(child, child.left);
        if (child.right != null) connect(child, child.right);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        adjList = new HashMap<>();
        connect(null, root);
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(target.val);
        seen.add(target.val);
        int level = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> nextLevel = new ArrayList<>();
            for (Integer currNode : ans) {
                List<Integer> adjNodeList = adjList.get(currNode);
                if (adjNodeList == null) return new ArrayList<Integer>();
                for (Integer neighbor : adjNodeList) {
                    if (!seen.contains(neighbor)) {
                        nextLevel.add(neighbor);
                        seen.add(neighbor);
                    }
                }
            }
            ans = nextLevel;
            level++;
        }
        if (level == k) return ans;
        return new ArrayList<Integer>();
    }
}