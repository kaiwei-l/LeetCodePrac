class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        def move(point, direction):
            if direction == "N":
                point[1] += 1
            elif direction == "S":
                point[1] -= 1
            elif direction == "W":
                point[0] -= 1
            else:
                point[0] += 1
        
        def turn(direction, where):
            if where == "L":
                if direction == "N":
                    return "W"
                elif direction == "W":
                    return "S"
                elif direction == "S":
                    return "E"
                elif direction == "E":
                    return "N"
            else:
                if direction == "N":
                    return "E"
                elif direction == "W":
                    return "N"
                elif direction == "S":
                    return "W"
                elif direction == "E":
                    return "S"
                
        point = [0, 0]
        direction = "N"
        for i in instructions:
            if i == "G":
                move(point, direction)
            else:
                direction = turn(direction, i)
        if point == [0, 0] or direction != "N":
            return True
        return False
                