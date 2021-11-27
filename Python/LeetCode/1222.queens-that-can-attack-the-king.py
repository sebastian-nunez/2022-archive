#
# @lc app=leetcode id=1222 lang=python3
#
# [1222] Queens That Can Attack the King
#

# @lc code=start
class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        n = 8
        output = []

        def inside(x, y):
            return x >= 0 and x < n and y >= 0 and y < n

        taken = [[False for col in range(n)] for row in range(n)]
        for queen in queens:
            taken[queen[0]][queen[1]] = True

        for dx in range(-1, 2):
            for dy in range(-1, 2):
                if dx == 0 and dy == 0:
                    continue

                x = king[0]
                y = king[1]
                while inside(x, y) and not taken[x][y]:
                    x += dx
                    y += dy

                    if inside(x, y) and taken[x][y]:
                        output.append([x, y])

        return output
# @lc code=end
