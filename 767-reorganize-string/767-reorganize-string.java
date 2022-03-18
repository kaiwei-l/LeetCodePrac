class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        PriorityQueue<Pair<Character, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            counter.put(currChar, counter.getOrDefault(currChar, 0) + 1);
        }
        for (Character c : counter.keySet()) {
            q.add(new Pair<Character, Integer>(c, counter.get(c)));
        }
        String ans = "";
        while (!q.isEmpty()) {
            Pair<Character, Integer> pair1 = q.poll();
            Character firstChar = pair1.getKey();
            Integer firstCount = pair1.getValue();
            if (ans.length() == 0 || ans.charAt(ans.length() - 1) != firstChar) {
                ans = ans + firstChar;
                firstCount--;
                if (firstCount > 0) q.add(new Pair<Character, Integer>(firstChar, firstCount));
            } else {
                Pair<Character, Integer> pair2 = q.poll();
                if (pair2 == null) return "";
                Character secondChar = pair2.getKey();
                Integer secondCount = pair2.getValue();
                ans = ans + secondChar;
                secondCount--;
                if (secondCount > 0) q.add(new Pair<Character, Integer>(secondChar, secondCount));
                q.add(new Pair<Character, Integer>(firstChar, firstCount));
            }
        }
        return ans;
    }
}