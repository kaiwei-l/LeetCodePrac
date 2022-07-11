class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int start = 0;
        int end = 0;
        while (start < words.length) {
            end = findLastWordIndex(words, start, maxWidth);
            String line = justify(words, start, end, maxWidth);
            ans.add(line);
            start = end + 1;
        }
        return ans;
    }
    
    public int findLastWordIndex(String[] words, int left, int maxWidth) {
        int currentWidth = words[left].length();
        int right = left + 1;
        while (right < words.length && (currentWidth + 1 + words[right].length() <= maxWidth)) {
            currentWidth += 1 + words[right].length();
            right++;
        }
        return --right;
    }
    
    public String justify(String[] words, int left, int right, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);
        
        boolean isLastLine = (right == words.length - 1);
        int len = 0;
        for (int i = left; i <= right; i++) {
            len += words[i].length();
        }
        int numSpace = maxWidth - len;
        int numWordsToPad = right - left;
        
        StringBuilder sb = new StringBuilder();
        
        String spaceStr = isLastLine ? " " : blank(numSpace / numWordsToPad);
        int remainderSpaceCount = isLastLine ? 0 : numSpace % numWordsToPad;
        
        for (int i = left; i <= right; i++) {
            sb.append(words[i]).append(spaceStr);
            if (remainderSpaceCount > 0) {
                sb.append(" ");
                remainderSpaceCount--;
            }
        }
        String line = sb.toString().trim();
        return padResult(line, maxWidth);
    }
    
    public String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }
    
    public String blank(int count) {
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            sb.append(" ");
            count--;
        }
        return sb.toString();
    }
}