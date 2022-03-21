class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLen = beginWord.length();
        
        HashMap<String, List<String>> allComboDict = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < wordLen; j++) {
                String newWord = word.substring(0, j) + "*" + word.substring(j + 1, wordLen);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        }
        
        ArrayDeque<Pair<String, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair(beginWord, 1));
        
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.removeFirst();
            String word = node.getKey();
            Integer level = node.getValue();
            for (int i = 0; i < wordLen; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);
                List<String> adjacentWordList = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                for (int j = 0; j < adjacentWordList.size(); j++) {
                    String adjacentWord = adjacentWordList.get(j);
                    if (adjacentWord.equals(endWord)) return ++level;
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        q.addLast(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}