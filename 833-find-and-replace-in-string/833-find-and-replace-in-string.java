class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(i)) {
                sb.append(s.charAt(i));
            } else {
                int indx = map.get(i);
                String sub = sources[indx];
                if (s.substring(i, i + sub.length()).equals(sub)) {
                    sb.append(targets[indx]);
                    i += sub.length() - 1;
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
    
}