class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
        }
        return maxArea;
    }
}