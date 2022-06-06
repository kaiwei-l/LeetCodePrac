/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            mapping.put(i, 0);
        }
        
        for (int i = 0; i < n; i++) {
            if (mapping.get(i) == 0) {
                for (int j = 0; j != i && j < n; j++) {
                    if (knows(i, j)) {
                        mapping.put(i, -1);
                    } else {
                        mapping.put(j, -1);
                    }
                }
            }
        }
        for (int candidate : mapping.keySet()) {
            if (mapping.get(candidate) == 0 && isCelebrity(candidate, n)) {
                return candidate;
            }
        }
        return -1;
    }
    
    public boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (i != j && (knows(i, j) || !knows(j, i))) return false;
        }
        return true;
    }
}