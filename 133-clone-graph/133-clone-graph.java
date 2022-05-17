/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node[] visited = new Node[101];
        dfs(node, visited);
        return visited[node.val];
    }
    
    public Node dfs(Node root, Node[] visited) {
        if (root == null) {
            return null;
        }
        if (visited[root.val] != null) {
            return visited[root.val];
        }
        Node copy = new Node(root.val);
        visited[root.val] = copy;
        for (Node neighbor : root.neighbors) {
            copy.neighbors.add(dfs(neighbor, visited));
        }
        return visited[root.val];
    }
}