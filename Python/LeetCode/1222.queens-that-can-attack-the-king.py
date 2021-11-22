#
# @lc app=leetcode id=1222 lang=python3
#
# [1222] Queens That Can Attack the King
#

# @lc code=start
class Solution:
    def inside(self, row, col):
        return row >= 0 and row < 8 and col >= 0 and col < 8

    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        output = []

        taken = [[False for col in range(8)] for row in range(8)]
        for queen in queens:
            taken[queen[0]][queen[1]] = True

        for d_row in range(-1, 2):
            for d_col in range(-1, 2):
                if d_row == 0 and d_col == 0:
                    continue

                row = king[0]
                col = king[1]
                while True:
                    row += d_row
                    col += d_col

                    if not self.inside(row, col):
                        break

                    if taken[row][col]:
                        output.append([row, col])
                        break

        return output

# @lc code=end
