class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int x = nums1.length;
        int y = nums2.length;
        
        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            
            int maxLeftX;
            int minRightX;
            int maxLeftY;
            int minRightY;
            
            if (partitionX == 0) {
                maxLeftX = Integer.MIN_VALUE;
            } else {
                maxLeftX = nums1[partitionX - 1];
            }
            if (partitionX == x) {
                minRightX = Integer.MAX_VALUE;
            } else {
                minRightX = nums1[partitionX];
            }
            if (partitionY == 0) {
                maxLeftY = Integer.MIN_VALUE;
            } else {
                maxLeftY = nums2[partitionY - 1];
            }
            if (partitionY == y) {
                minRightY = Integer.MAX_VALUE;
            } else {
                minRightY = nums2[partitionY];
            }
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0.0;
    }
}