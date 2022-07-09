/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random rand = new Random();
        int matches = 0;
        for (int i = 0; i < 10; i++) {
            if (matches == 6) break;
            String w = wordlist[rand.nextInt(wordlist.length)];
            matches = master.guess(w);
            List<String> temp = new ArrayList<>();
            for (String s : wordlist) {
                if (matches == getMatch(s, w)) temp.add(s);
            }
            wordlist = temp.toArray(new String[0]);
        }
    }
    
    public int getMatch(String s, String w) {
        int match = 0;
        for (int i = 0; i < 6; i++) {
            if (s.charAt(i) == w.charAt(i)) match++;
        }
        return match;
    }
}