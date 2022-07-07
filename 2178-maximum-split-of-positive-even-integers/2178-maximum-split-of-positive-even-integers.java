class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) return new ArrayList<Long>();
        
        List<Long> ans = new ArrayList<Long>();
        long sum = 0;
        long num = 2;
        while (sum + num <= finalSum) {
            ans.add(num);
            sum += num;
            num += 2;
        }
        int size = ans.size();
        long last = ans.get(size - 1) + (finalSum - sum);
        ans.set(size - 1, last);
        return ans;
    }
}