class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(1);
        if (rowIndex == 0) return curr;
        for (int i = 1; i <= rowIndex; i++) {
            if (rowIndex == 1) {
                curr.add(1);
                return curr;
            }
            ArrayList<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 0; j < curr.size() - 1; j++) {
                next.add(curr.get(j) + curr.get(j + 1));
            }
            next.add(1);
            curr = next;
        }
        return curr;
    }
}