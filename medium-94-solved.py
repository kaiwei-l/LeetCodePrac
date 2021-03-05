# https://leetcode.com/problems/binary-tree-inorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        def inorderTraversalAux(node, res):
            if node is None:
                return
            else:
                inorderTraversalAux(node.left, res)
                res.append(node.val)
                inorderTraversalAux(node.right, res)

        if root is None:
            return []
        res = []
        inorderTraversalAux(root, res)
        return res
        