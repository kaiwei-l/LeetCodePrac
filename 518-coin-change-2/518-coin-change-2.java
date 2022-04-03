class Solution {
    public int change(int amount, int[] coins) {
        int[] combo = new int[amount + 1];
        combo[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < combo.length; i++) {
                if (i >= coin) {
                    combo[i] += combo[i - coin];
                }
            }
        }
        return combo[amount];
    }
}