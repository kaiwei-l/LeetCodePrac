class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mod = (int)Math.pow(10, 9) + 7;
        long horizontalDiff = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[horizontalCuts.length - 1]);
        long verticalDiff = Math.max(verticalCuts[0] - 0, w - verticalCuts[verticalCuts.length - 1]);
        
        for (int i = 1; i < horizontalCuts.length; i++) {
            horizontalDiff = Math.max(horizontalDiff, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int j = 1; j < verticalCuts.length; j++) {
            verticalDiff = Math.max(verticalDiff, verticalCuts[j] - verticalCuts[j - 1]);
        }
        return (int)(horizontalDiff * verticalDiff % mod);
    }
}