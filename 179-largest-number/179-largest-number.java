class Solution {
    public String largestNumber(int[] nums) {
        Integer[] numsCopy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        
        Arrays.sort(numsCopy, (Integer a, Integer b) -> {
            String str1 = String.valueOf(a);
            String str2 = String.valueOf(b);
            Long x = Long.parseLong(str1 + str2);
            Long y = Long.parseLong(str2 + str1);
            if (x == y) return 0;
            if (x < y) return 1;
            return -1;
        });
        
        if (numsCopy[0] == 0) return "0";
        StringBuilder ans = new StringBuilder();
        for (int num : numsCopy) {
            ans.append(num);
        }
        return ans.toString();
    }
}