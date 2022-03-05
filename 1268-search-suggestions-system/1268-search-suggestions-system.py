class Trie:
    def __init__(self):
        self.sub = dict()
        self.suggestions = []

class Solution:
    def insert(self, product, root):
        trie = root
        for c in product:
            if c not in trie.sub:
                trie.sub[c] = Trie()
            trie = trie.sub[c]
            trie.suggestions.append(product)
            trie.suggestions.sort()
            if len(trie.suggestions) > 3:
                trie.suggestions.pop()
    
    def search(self, searchWord, root):
        ans = []
        for c in searchWord:
            if root:
                root = root.sub.get(c)
            ans.append(root.suggestions if root else [])
        return ans
                
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        root = Trie()
        for product in products:
            self.insert(product, root)
        return self.search(searchWord, root)
    
    