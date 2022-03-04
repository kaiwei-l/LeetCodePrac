class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = []
        counter = dict()
        for s in strs:
            if len(s) == 0:
                if "empty" in counter.keys():
                    counter["empty"].append("")
                else:
                    counter["empty"] = [""]
            else:
                key = 0
                for c in s:
                    key += hash(c)
                if key in counter.keys():
                    counter[key].append(s)
                else:
                    counter[key] = [s]
        for key, val in counter.items():
            res.append(val)
        return res
            