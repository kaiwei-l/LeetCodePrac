class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> oneIndx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) oneIndx.add(i);
        }
        List<Integer> prefixSum = new ArrayList<Integer>();
        prefixSum.add(0);
        for (int i = 0; i < oneIndx.size(); i++) {
            prefixSum.add(oneIndx.get(i) + prefixSum.get(i));
        }
        
        Integer ans = Integer.MAX_VALUE;
        Integer n = oneIndx.size();
        Integer radius;
        Integer right;
        Integer left;
        if (k % 2 == 1) {
            radius = (k - 1) / 2;
            for (int mid = radius; mid < n - radius; mid++) {
                right = prefixSum.get(mid + radius + 1) - prefixSum.get(mid + 1);
                left = prefixSum.get(mid) - prefixSum.get(mid - radius);
                ans = Math.min(ans, right - left);
            }
            return ans - radius * (radius + 1);
        } else {
            radius = (k - 2) / 2;
            for (int mid = radius; mid < n - radius - 1; mid++) {
                right = prefixSum.get(mid + radius + 2) - prefixSum.get(mid + 1);
                left = prefixSum.get(mid) - prefixSum.get(mid - radius);
                ans = Math.min(ans, right - left - oneIndx.get(mid));
            }
            return ans - radius * (radius + 1) - (radius + 1);
        }
    }
}