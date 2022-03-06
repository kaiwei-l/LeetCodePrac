class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        def dfs(word, wordSet):
            for i in range(1, len(word)):
                prefix = word[:i]
                postfix = word[i:]
                if prefix in wordSet and postfix in wordSet:
                    return True
                if prefix in wordSet and dfs(postfix, wordSet):
                    return True
                if postfix in wordSet and dfs(prefix, wordSet):
                    return True
            return False
        
        d = set(words)
        res = []
        for word in words:
            if dfs(word, d):
                res.append(word)
        return res
        