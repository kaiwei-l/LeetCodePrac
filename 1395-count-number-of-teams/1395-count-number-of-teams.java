class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int middle = rating[i];
            int leftLargerCount = 0;
            int leftSmallerCount = 0;
            int rightLargerCount = 0;
            int rightSmallerCount = 0;
            for (int left = 0; left < i; left++) {
                if (rating[left] > middle) {
                    leftLargerCount++;
                } else {
                    leftSmallerCount++;
                }
            }
            for (int right = i + 1; right < rating.length; right++) {
                if (rating[right] > middle) {
                    rightLargerCount++;
                } else {
                    rightSmallerCount++;
                }
            }
            if (leftSmallerCount != 0 && rightLargerCount != 0) {
                ans += leftSmallerCount * rightLargerCount;
            }
            if (leftLargerCount != 0 && rightSmallerCount != 0) {
                ans += leftLargerCount * rightSmallerCount;
            }
        }
        return ans;
    }
}