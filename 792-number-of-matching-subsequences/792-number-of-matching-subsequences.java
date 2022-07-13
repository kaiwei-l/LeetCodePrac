class Node {
    String w;
    int indx;
    public Node(String word, int indx) {
        this.w = word;
        this.indx = indx;
    }
}

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        ArrayList<Node>[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (String w : words) {
            buckets[w.charAt(0) - 'a'].add(new Node(w, 0));
        }
        
        for (char c : s.toCharArray()) {
            ArrayList<Node> oldBucket = buckets[c - 'a'];
            buckets[c - 'a'] = new ArrayList<>();
            for (Node n : oldBucket) {
                n.indx++;
                if (n.indx == n.w.length()) {
                    ans++;
                } else {
                    buckets[n.w.charAt(n.indx) - 'a'].add(n);
                }
            }
        }
        return ans;
    }
}