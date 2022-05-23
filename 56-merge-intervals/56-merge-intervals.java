class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayDeque<int[]> s = new ArrayDeque<>();
        for (int[] i : intervals) {
            if (s.isEmpty()) {
                s.addLast(i);
            } else {
                while (!s.isEmpty()) {
                    int[] prev = s.removeLast();
                    if (prev[1] < i[0]) {
                        s.addLast(prev);
                        break;
                    } else {
                        i[0] = Math.min(i[0], prev[0]);
                        i[1] = Math.max(i[1], prev[1]);
                    }
                }
                s.addLast(i);
            }
        }
        return s.toArray(new int[s.size()][2]);
    }
}