class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int leftMaxSeen = height[0];
        int rightMaxSeen = height[n - 1];
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= leftMaxSeen) {
                leftMax[i] = height[i];
                leftMaxSeen = height[i];
            } else {
                leftMax[i] = leftMaxSeen;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] >= rightMaxSeen) {
                rightMax[i] = height[i];
                rightMaxSeen = height[i];
            } else {
                rightMax[i] = rightMaxSeen;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}