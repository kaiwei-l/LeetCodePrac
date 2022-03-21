class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            Integer curr = asteroids[i];
            boolean push = true;
            while (!stack.isEmpty() && curr < 0 && stack.getLast() > 0) {
                int topAbs = Math.abs(stack.getLast());
                int currAbs = Math.abs(curr);
                
                if (topAbs >= currAbs) {
                    push = false;
                    if (topAbs == currAbs) {
                        stack.removeLast();
                    }
                    break;
                } else {
                    stack.removeLast();
                }
            }
            if (push) stack.addLast(curr);
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.removeFirst();
        }
        return ans;
    }
}