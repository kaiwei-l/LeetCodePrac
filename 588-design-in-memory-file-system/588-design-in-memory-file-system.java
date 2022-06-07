class Dir {
    HashMap<String, Dir> dir;
    HashMap<String, String> files;
    public Dir() {
        dir = new HashMap<>();
        files = new HashMap<>();
    }
}

class FileSystem {
    Dir root;
    
    public FileSystem() {
        root = new Dir();    
    }
    
    public List<String> ls(String path) {
        Dir p = root;
        List<String> res = new ArrayList<>();
        
        if (path.equals("/")) {
            res.addAll(new ArrayList<>(p.dir.keySet()));
            res.addAll(new ArrayList<>(p.files.keySet()));
        } else {
            String[] d = path.split("/");
            int n = d.length;
            for (int i = 1; i < n - 1; i++) {
                p = p.dir.get(d[i]);
            }
            if (p.files.containsKey(d[n - 1])) {
                res.add(d[n - 1]);
                return res;
            } else {
                p = p.dir.get(d[n - 1]);
                res.addAll(new ArrayList<>(p.dir.keySet()));
                res.addAll(new ArrayList<>(p.files.keySet()));
            }
        }
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        Dir p = root;
        String[] d = path.split("/");
        int n = d.length;
        for (int i = 1; i < n; i++) {
            if (!p.dir.containsKey(d[i])) {
                p.dir.put(d[i], new Dir());
            }
            p = p.dir.get(d[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir p = root;
        String[] d = filePath.split("/");
        int n = d.length;
        for (int i = 1; i < n - 1; i++) {
            p = p.dir.get(d[i]);
        }
        if (p.files.containsKey(d[n - 1])) {
            p.files.put(d[n - 1], p.files.get(d[n - 1]) + content);
        } else {
            p.files.put(d[n - 1], content);
        }
    }
    
    public String readContentFromFile(String filePath) {
        Dir p = root;
        String[] d = filePath.split("/");
        int n = d.length;
        for (int i = 1; i < n - 1; i++) {
            p = p.dir.get(d[i]);
        }
        return p.files.get(d[n - 1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */