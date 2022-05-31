/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sAux(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] strArr = data.split(",");
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (String s : strArr) {
            q.addLast(Integer.valueOf(s));
        }
        return dAux(Integer.MIN_VALUE, Integer.MAX_VALUE, q);
    }
    
    public void sAux(TreeNode node, StringBuilder sb)  {
        if (node == null) return;
        sb.append(node.val);
        sb.append(",");
        sAux(node.left, sb);
        sAux(node.right, sb);
    }
    
    public TreeNode dAux(int lo, int hi, ArrayDeque<Integer> q) {
        if (q.isEmpty()) return null;
        int v = q.getFirst();
        if (v < lo || v > hi) return null;
        q.removeFirst();
        TreeNode n = new TreeNode(v);
        n.left = dAux(lo, v, q);
        n.right = dAux(v, hi, q);
        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;