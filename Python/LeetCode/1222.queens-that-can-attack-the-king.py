#
# @lc app=leetcode id=1222 lang=python3
#
# [1222] Queens That Can Attack the King
#

# @lc code=start
class Solution:
    def inside(self, x, y, n):
        return x >= 0 and x < n and y >= 0 and y < n

    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        n = 8
        output = []

        taken = [[False for y in range(n)] for x in range(n)]
        for queen in queens:
            taken[queen[0]][queen[1]] = True

        for dx in range(-1, 2):
            for dy in range(-1, 2):
                if dx == 0 and dy == 0:
                    continue

                x = king[0]
                y = king[1]
                while True:
                    x += dx
                    y += dy

                    if not self.inside(x, y, n):
                        break

                    if taken[x][y]:
                        output.append([x, y])
                        break

        return output
# @lc code=end
