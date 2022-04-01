class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        
        int left = 0;
        int right = 0;
        int ans = 0;
        int n = chars.length;
        char currChar = chars[left];
        int updateIndx = 0;
        while (right < n) {
            currChar = chars[left];
            if (chars[left] == chars[right]) {
                right++;
            } else {
                int groupLen = right - left;
                if (groupLen == 1) {
                    ans++;
                    chars[updateIndx] = currChar;
                    updateIndx++;
                } else {
                    int digitCount = String.valueOf(groupLen).length();
                    String groupLenStr = String.valueOf(groupLen);
                    ans += 1 + digitCount;
                    chars[updateIndx] = currChar;
                    updateIndx++;
                    for (int i = 0; i < digitCount; i++) {
                        char currDigit = groupLenStr.charAt(i);
                        chars[updateIndx] = currDigit;
                        updateIndx++;
                    }
                }
                left = right;
            }
        }
        int groupLen = right - left;
        if (groupLen == 1) {
            ans++;
            chars[updateIndx] = currChar;
            updateIndx++;
        } else {
            int digitCount = String.valueOf(groupLen).length();
            String groupLenStr = String.valueOf(groupLen);
            ans += 1 + digitCount;
            chars[updateIndx] = currChar;
            updateIndx++;
            for (int i = 0; i < digitCount; i++) {
                char currDigit = groupLenStr.charAt(i);
                chars[updateIndx] = currDigit;
                updateIndx++;
            }
        }
        return ans;
    }
}