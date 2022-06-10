class Solution {
    int count;
    
    public int countArrangement(int n) {
        if (n == 1) return 1;
        count = 0;
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }
    
    public void backtrack(int n, int indx, boolean[] visited) {
        if (indx > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (indx % i == 0 || i % indx == 0)) {
                visited[i] = true;
                backtrack(n, indx + 1, visited);
                visited[i] = false;
            }
        }
    }
}