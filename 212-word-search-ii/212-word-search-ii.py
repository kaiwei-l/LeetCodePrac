class Trie:
    def __init__(self):
        self.counter = {}
        self.word = ""
    
class Solution:
    def insert(self, word, root, indx):
        while indx != len(word):
            char = word[indx]
            trie = root.counter.get(char)
            if trie is None:
                root.counter[char] = Trie()
                trie = root.counter[char]
            root = trie
            indx += 1
        root.word = word
    
    def canVisit(self, row, col, i, j):
        if 0 <= i < row and 0 <= j < col:
            return True
        return False
    
    def search(self, root, i, j, board, visited, rowLimit, colLimit, ans):
        currChar = board[i][j]
        currNode = root.counter[currChar]
        visited.add((i, j))
        
        if currNode.word != "":
            ans.append(currNode.word)
            currNode.word = ""
        
        for rowChange in range(-1, 2):
            newRow = i + rowChange
            if self.canVisit(rowLimit, colLimit, newRow, j) and (newRow, j) not in visited and board[newRow][j] in currNode.counter:
                self.search(currNode, newRow, j, board, visited, rowLimit, colLimit, ans)
        for colChange in range(-1, 2):
            newCol = j + colChange
            if self.canVisit(rowLimit, colLimit, i, newCol) and (i, newCol) not in visited and board[i][newCol] in currNode.counter:
                self.search(currNode, i, newCol, board, visited, rowLimit, colLimit, ans)
        visited.remove((i, j))
        if len(currNode.counter) == 0:
            del root.counter[currChar]
        

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
            root = Trie()
            for word in words:
                self.insert(word, root, 0)
            ans = []
            m = len(board)
            n = len(board[0])
            for i in range(m):
                for j in range(n):
                    visited = set()
                    if board[i][j] in root.counter:
                        self.search(root, i, j, board, visited, m, n, ans)
            return ans
            