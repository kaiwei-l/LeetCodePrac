# https://leetcode.com/problems/generate-parentheses/

# My solution
# class Solution:
#     def generateParenthesis(self, n: int) -> List[str]:
#         def isValid(p):
#             counter = 0
#             for c in p:
#                 if c == "(":
#                     counter += 1
#                 else:
#                     counter -= 1
#                 if counter < 0:
#                     return False
#             if counter == 0:
#                 return True
#             else:
#                 return False
        
#         def helper(res, leftP, rightP, parenthesis, length):
#             if len(parenthesis) == length and isValid(parenthesis):
#                 res.append(parenthesis)
#                 return
#             if leftP != 0:
#                 parenthesis += "("
#                 leftP -= 1
#                 helper(res, leftP, rightP, parenthesis, length)
#                 parenthesis = parenthesis[:-1]
#                 leftP += 1
#             if rightP != 0:
#                 parenthesis += ")"
#                 rightP -= 1
#                 helper(res, leftP, rightP, parenthesis, length)
#                 rightP += 1
#                 parenthesis = parenthesis[:-1]
#             return
        
#         res = []
#         leftP = n
#         rightP = n
#         parenthesis = ""
#         length = n * 2
#         helper(res, leftP, rightP, parenthesis, length)
#         return res

class Solution(object):
    def generateParenthesis(self, N):
        ans = []
        def backtrack(S = '', left = 0, right = 0):
            if len(S) == 2 * N:
                ans.append(S)
                return
            if left < N:
                backtrack(S+'(', left+1, right)
            if right < left:
                backtrack(S+')', left, right+1)

        backtrack()
        return ans