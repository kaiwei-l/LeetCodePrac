class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayDeque<int[]> s = new ArrayDeque<>();
        ArrayList<int[]> list = new ArrayList<>();
        boolean newIntervalAdded = false;
        for (int[] i : intervals) {
            if (newIntervalAdded) {
                list.add(i);
            } else {
                if (i[0] < newInterval[0]) {
                    list.add(i);
                } else if (i[0] == newInterval[0]) {
                    list.add(i);
                    list.add(newInterval);
                    newIntervalAdded = true;
                } else {
                    list.add(newInterval);
                    list.add(i);
                    newIntervalAdded = true;
                }   
            }
        }
        
        if (!newIntervalAdded) list.add(newInterval);
        
        for (int[] curr : list) {
            if (s.isEmpty()) {
                s.addLast(curr);
            } else {
                while (!s.isEmpty()) {
                    int[] prev = s.removeLast();
                    if (prev[1] < curr[0]) {
                        s.addLast(prev);
                        break;
                    } else {
                        curr[0] = Math.min(curr[0], prev[0]);
                        curr[1] = Math.max(curr[1], prev[1]);
                    }
                }
                s.addLast(curr);
            }
        }
        
        return s.toArray(new int[s.size()][2]);
    }
    
    public boolean isOverlapping(int[] interval1, int[] interval2) {
        if (interval2[0] > interval1[1]) {
            return false;
        }
        return true;
    }
}