class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                char a = (char)(97 + i);
                char b = (char)(97 + j);
                int var = 0;
                boolean hasB = false;
                boolean bHead = false;
                for (char c : s.toCharArray()) {
                    if (c == a) {
                        var++;
                    } else if (c == b) {
                        hasB = true;
                        if (bHead && var >= 0) {
                            bHead = false;
                        } else if (--var < 0) {
                            bHead = true;
                            var = -1;
                        }
                    }
                    ans = Math.max(ans, hasB ? var : 0);
                }
            }
        }
        return ans;
    }
}