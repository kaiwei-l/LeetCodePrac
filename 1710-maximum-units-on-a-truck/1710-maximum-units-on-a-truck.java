class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int max = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int numOfBox = boxTypes[i][0];
            int numOfUnit = boxTypes[i][1];
            if (numOfBox <= truckSize) {
                truckSize -= numOfBox;
                max += numOfBox * numOfUnit;
            } else {
                max += truckSize * numOfUnit;
                break;
            }
        }
        return max;
    }
}