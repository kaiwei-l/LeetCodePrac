class Solution {
    public int sumSubarrayMins(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> prevMin = new HashMap<>();
        HashMap<Integer, Integer> nextMin = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.getLast()] >= arr[i]) {
                stack.removeLast();
            }
            if (stack.isEmpty()) {
                prevMin.put(i, -1);
            } else {
                prevMin.put(i, stack.getLast());
            }
            stack.addLast(i);
        }
        stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.getLast()] > arr[i]) {
                stack.removeLast();
            }
            if (stack.isEmpty()) {
                nextMin.put(i, arr.length);
            } else {
                nextMin.put(i, stack.getLast());
            }
            stack.addLast(i);
        }
        
        long ans = 0;
        long mod = (int)Math.pow(10.0, 9.0) + 7;
        for (int i = 0; i < arr.length; i++) {
            long leftMin = i - prevMin.get(i);
            long rightMin = nextMin.get(i) - i;
            ans = (ans + arr[i] * leftMin * rightMin) % mod;
        }
        return (int)ans;
    }
}