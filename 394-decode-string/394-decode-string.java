class Solution {
    public String decodeString(String s) {
        ArrayDeque<Integer> countStack = new ArrayDeque<>();
        ArrayDeque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.addLast(k);
                stringStack.addLast(currentString);
                k = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                int count = countStack.removeLast();
                StringBuilder decodedString = stringStack.removeLast();
                for (int j = 0; j < count; j++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}