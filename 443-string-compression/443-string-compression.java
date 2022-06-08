class Solution {
    public int compress(char[] chars) {
        int indx = 0;
        int count = 1;
        char currChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != currChar) {
                chars[indx] = currChar;
                indx++;
                if (count != 1) {
                    String cCount = String.valueOf(count);
                    for (char d : cCount.toCharArray()) {
                        chars[indx] = d;
                        indx++;
                    }
                }
                currChar = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        chars[indx] = currChar;
        indx++;
        if (count != 1) {
            String cCount = String.valueOf(count);
            for (char d : cCount.toCharArray()) {
                chars[indx] = d;
                indx++;
            }
        }
        return indx;
    }
}