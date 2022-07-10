class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> memo = new ArrayList<>();
        int same = 0;
        for (List<Integer> point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);
            if (dx == 0 && dy == 0) {
                same++;
            } else {
                double degree = Math.toDegrees(Math.atan2(dy, dx));
                memo.add(degree);
            }
        }
        
        Collections.sort(memo);
        int n = memo.size();
        for (int i = 0; i < n; i++) {
            if (memo.get(i) < n) memo.add(memo.get(i) + 360);
        }
        
        int count = 0;
        int start = 0;
        for (int end = 0; end < memo.size(); end++) {
            while (memo.get(end) - memo.get(start) > angle) {
                start++;
            }
            count = Math.max(count, end - start + 1);
        }
        return count + same;
    }
}