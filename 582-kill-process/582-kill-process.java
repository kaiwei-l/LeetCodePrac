class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> parentToChild = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < pid.size(); i++) {
            Integer parent = ppid.get(i);
            Integer child = pid.get(i);
            if (parent != 0) {
                List<Integer> childList = parentToChild.getOrDefault(parent, new ArrayList<Integer>());
                childList.add(child);
                parentToChild.put(parent, childList);
            }
        }
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ans.add(kill);
        q.addLast(kill);
        while (!q.isEmpty()) {
            Integer currProcess = q.removeFirst();
            List<Integer> childList = parentToChild.get(currProcess);
            if (childList != null) {
                for (Integer child : childList) {
                    q.addLast(child);
                    ans.add(child);
                }
            }
        }
        return ans;
    }
}