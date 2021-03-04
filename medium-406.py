# https://leetcode.com/problems/queue-reconstruction-by-height/

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if not people:
            return []
        
        people_dict = dict()
        height = []
        res = []
        
        for i in range(len(people)):
            person = people[i]
            if person[0] in people_dict:
                people_dict[person[0]].append((person[1], i))
            else:
                people_dict[person[0]] = [(person[1], i)]
                height.append(person[0])
        
        height.sort()
        for i in range(len(height) - 1, -1, -1):
            h = height[i]
            people_dict[h].sort()
            for p in people_dict[h]:
                res.insert(p[0], people[p[1]])
        return res