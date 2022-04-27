class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);
        if (numRows == 1) return ans;
        ArrayList<Integer> secRow = new ArrayList<>();
        secRow.add(1);
        secRow.add(1);
        ans.add(secRow);
        if (numRows == 2) return ans;
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                int num = ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1);
                currRow.add(num);
            }
            currRow.add(1);
            ans.add(currRow);
        }
        return ans;
    }
}