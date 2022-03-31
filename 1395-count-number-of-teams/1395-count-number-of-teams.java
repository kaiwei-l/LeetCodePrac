class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        for (int j = 0; j < rating.length; j++) {
            int leftSmaller = 0;
            int rightLarger = 0;
            int leftLarger = 0;
            int rightSmaller = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) leftSmaller++;
                if (rating[i] > rating[j]) leftLarger++;
            }
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[k] < rating[j]) rightSmaller++;
                if (rating[k] > rating[j]) rightLarger++;
            }
            count += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }
        return count;
    }
}