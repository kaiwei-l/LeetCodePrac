class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, ArrayList<Boolean>> counter = new HashMap<>();
        int numOfPairs = 0;
        if (k == 0) {
            HashMap<Integer, Integer> uniqueCounter = new HashMap<>();
            for (int i : nums) {
                uniqueCounter.put(i, uniqueCounter.getOrDefault(i, 0) + 1);
            }
            for (Integer key : uniqueCounter.keySet()) {
                if (uniqueCounter.get(key) > 1) {
                    numOfPairs++;
                }
            }
            return numOfPairs;
        }
        for (int i = 0; i < nums.length; i++) {
            int currInt = nums[i];
            ArrayList<Boolean> used = new ArrayList<>();
            used.add(false);
            used.add(false);
            int smallerInt = currInt - k;
            int largerInt = currInt + k;
            if (counter.containsKey(smallerInt)) {
                ArrayList<Boolean> usedSmall = counter.get(smallerInt);
                if (usedSmall.get(1) == false) {
                    usedSmall.set(1, true);
                    counter.put(smallerInt, usedSmall);
                    numOfPairs++;
                }
                used.set(0, true);
            }
            if (counter.containsKey(largerInt)) {
                ArrayList<Boolean> usedLarge = counter.get(largerInt);
                if (usedLarge.get(0) == false) {
                    usedLarge.set(0, true);
                    counter.put(largerInt, usedLarge);
                    numOfPairs++;
                }
                used.set(1, true);
            }
            counter.put(currInt, used);
        }
        return numOfPairs;
    }
}