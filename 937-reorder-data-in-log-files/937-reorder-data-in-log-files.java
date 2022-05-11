class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digiLogs = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        
        for (String log : logs) {
            if (isDigiLog(log)) {
                digiLogs.add(log);
            } else {
                ans.add(log);
            }
        }
        
        Collections.sort(ans, (a, b) -> {
            String[] aArr = a.split(" ");
            String[] bArr = b.split(" ");
            String aId = aArr[0];
            String bId = bArr[0];
            String aContent = a.substring(aId.length() + 1, a.length());
            String bContent = b.substring(bId.length() + 1, b.length());
            if (aContent.equals(bContent)) return aId.compareTo(bId);
            return aContent.compareTo(bContent);
        });
        
        for (int i = 0; i < digiLogs.size(); i++) {
            ans.add(digiLogs.get(i));
        }
        
        return ans.toArray(new String[ans.size()]);
    }
    
    public boolean isDigiLog(String log) {
        String[] strArr = log.split(" ");
        String entry = strArr[1];
        for (int i = 0; i < entry.length(); i++) {
            if (!Character.isDigit(entry.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}