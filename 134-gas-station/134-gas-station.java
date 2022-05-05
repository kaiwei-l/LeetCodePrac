class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += gas[i] - cost[i];
        }
        if (totalCost < 0) return -1;
        int startPoint = 0;
        int currCost = 0;
        for (int i = 0; i < gas.length; i++) {
            currCost += gas[i] - cost[i];
            if (currCost < 0) {
                currCost = 0;
                startPoint = i + 1;
            }
        }
        return startPoint;
    }
}