class Solution {
    public String largestNumber(int[] nums) {
        Integer[] numsCopy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        
        Arrays.sort(numsCopy, (a, b) -> {
            String x = String.valueOf(a);
            String y = String.valueOf(b);
            Long leftRight = Long.valueOf(x + y);
            Long rightLeft = Long.valueOf(y + x);
            if (leftRight == rightLeft) return 0;
            if (leftRight > rightLeft) return -1;
            return 1;
        });
        
        StringBuilder s = new StringBuilder();
        if (numsCopy[0] == 0) return "0";
        for (int num : numsCopy) {
            s.append(num);
        }
        return s.toString();
    }
}