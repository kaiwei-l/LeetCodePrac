class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int[] inventoryRev = new int[inventory.length];
        for (int i = inventory.length - 1; i >= 0; i--) {
            int j = inventory.length - 1 - i;
            inventoryRev[j] = inventory[i];
        }
        long ans = 0, n = inventoryRev.length, curr = inventoryRev[0], i = 0;
        while (orders > 0) {
            while (i < n && inventoryRev[(int)i] == curr) {
                i++;
            }
            long next;
            if (i == n) {
                next = 0;
            } else {
                next = inventoryRev[(int)i];
            }
            long h = curr - next, remainder = 0, count = Math.min(orders, i * h);
            if (orders < i * h) {
                h = orders / i;
                remainder = orders % i;
            }
            long remainderValue = curr - h;
            ans += i * h * (curr + curr - h + 1) / 2 + remainder * remainderValue;
            orders -= count;
            curr = next;
        }
        ans = ans % 1000000007;
        return (int) ans;
    }
}