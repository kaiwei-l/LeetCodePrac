class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = (right - left) * Math.min(height[left], height[right]);
        
        while (left < right) {
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
            area = Math.max(area, (right - left) * Math.min(height[right], height[left]));
        }
        return area;
    }
}