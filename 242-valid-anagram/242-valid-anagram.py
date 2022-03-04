class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        counter = dict()
        for c in s:
            counter[c] = counter.get(c, 0) + 1
        for c in t:
            if c in counter.keys() and counter[c] != 0:
                counter[c] -= 1
            else:
                return False
        for key, val in counter.items():
            if val != 0:
                return False
        return True