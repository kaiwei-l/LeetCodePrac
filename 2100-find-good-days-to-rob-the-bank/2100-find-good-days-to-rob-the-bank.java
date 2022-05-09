class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] nonIncrease = new int[security.length];
        int[] nonDecrease = new int[security.length];
        int n = security.length;
        
        nonIncrease[0] = 1;
        for (int i = 1; i < n; i++) {
            nonIncrease[i] = (security[i - 1] >= security[i]) ? nonIncrease[i - 1] + 1 : 1; 
        }
        nonDecrease[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            nonDecrease[i] = (security[i] <= security[i + 1]) ? nonDecrease[i + 1] + 1 : 1;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i - time >= 0 && i + time <= n - 1) {
                if (nonIncrease[i] >= time + 1 && nonDecrease[i] >= time + 1) ans.add(i);
            }
        }
        return ans;
    }
}