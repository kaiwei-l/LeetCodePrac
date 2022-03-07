import abc 
from abc import ABC, abstractmethod 
"""
This is the interface for the expression tree Node.
You should not remove it, and you can define some classes to implement it.
"""

class Node(ABC):
    @abstractmethod
    # define your fields here
    def evaluate(self) -> int:
        pass

class BinaryNode(Node):
    def __init__(self, left, right):
        self.left = left
        self.right = right
    
    def evaluate(self):
        pass

class Plus(BinaryNode):
    def evaluate(self):
        return self.left.evaluate() + self.right.evaluate()

class Minus(BinaryNode):
    def evaluate(self):
        return self.left.evaluate() - self.right.evaluate()

class Multiply(BinaryNode):
    def evaluate(self):
        return self.left.evaluate() * self.right.evaluate()

class Divide(BinaryNode):
    def evaluate(self):
        return self.left.evaluate() // self.right.evaluate()

class Num(BinaryNode):
    def __init__(self, value):
        self.value = int(value)
    def evaluate(self):
        return self.value
"""    
This is the TreeBuilder class.
You can treat it as the driver code that takes the postinfix input
and returns the expression tree represnting it as a Node.
"""

class TreeBuilder(object):
    def buildTree(self, postfix: List[str]) -> 'Node':
        stack = []
        operators = {'+': Plus, '-': Minus, '*':Multiply, '/': Divide}
        for item in postfix:
            if item in operators:
                r = stack.pop()
                l = stack.pop()
                stack.append(operators[item](l, r))
            else:
                stack.append(Num(item))
        return stack[0]
                
		
"""
Your TreeBuilder object will be instantiated and called as such:
obj = TreeBuilder();
expTree = obj.buildTree(postfix);
ans = expTree.evaluate();
"""
        