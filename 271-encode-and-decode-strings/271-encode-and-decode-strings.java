public class Codec {
    int size = 0;
    List<Pair<Integer, Integer>> points;
    StringBuilder sb;
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        points = new ArrayList<>();
        sb = new StringBuilder();
        for (String s : strs) {
            if (s == "") {
                sb.append(" ");
                points.add(new Pair(-1, -1));
                size++;
            } else {
                sb.append(s);
                points.add(new Pair(size, size + s.length()));
                size += s.length();
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        for (Pair<Integer, Integer> point : points) {
            int left = point.getKey();
            int right = point.getValue();
            if (left == -1 && right == -1) {
                ans.add("");
            } else {
                ans.add(s.substring(left, right));
            }
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));