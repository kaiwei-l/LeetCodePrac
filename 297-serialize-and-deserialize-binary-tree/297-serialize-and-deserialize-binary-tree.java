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
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode n = q.removeFirst();
                if (n.val == -2000) {
                    sb.append("null,");
                } else {
                    sb.append(n.val);
                    sb.append(",");
                    q.addLast((n.left == null) ? new TreeNode(-2000) : n.left);
                    q.addLast((n.right == null) ? new TreeNode(-2000) : n.right);   
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodeArr = data.split(",");
        ArrayList<String> nodeList = new ArrayList<>(Arrays.asList(nodeArr));
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodeList.get(0)));
        q.addLast(root);
        int indx = 1;
        while (!q.isEmpty() && indx < nodeList.size()) {
            TreeNode n = q.removeFirst();
            if (!nodeList.get(indx).equals("null")) {
                TreeNode l = new TreeNode(Integer.valueOf(nodeList.get(indx)));
                n.left = l;
                q.addLast(l);
            }
            indx++;
            if (!nodeList.get(indx).equals("null")) {
                TreeNode r = new TreeNode(Integer.valueOf(nodeList.get(indx)));
                n.right = r;
                q.addLast(r);
            }
            indx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));