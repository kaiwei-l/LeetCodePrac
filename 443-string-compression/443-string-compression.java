class Solution {
    public int compress(char[] chars) {
        int endIndx = 0;
        int indx = 0;
        while (indx < chars.length) {
            char currChar = chars[indx];
            int count = 0;
            while (indx < chars.length && chars[indx] == currChar) {
                count++;
                indx++;
            }
            chars[endIndx] = currChar;
            endIndx++;
            if (count != 1) {
                String countStr = String.valueOf(count);
                for (int i = 0; i < countStr.length(); i++) {
                    chars[endIndx] = countStr.charAt(i);
                    endIndx++;
                }
            }
        }
        return endIndx;
    }
}