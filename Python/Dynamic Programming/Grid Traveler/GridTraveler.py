'''
Given an row x col 2D grid, find the number of combinations to travel
from the top-left corner to the bottom-right corner.

Restrictions:
- You can only move right or down

Paramters:
- row, col (both positive integers)

Output:
- number of combinations (integer)

gridtraveler(2, 3) = 3

-------------
S  |  X  |  X
-------------
X  |  X  |  E
-------------

Combinations: (right, right, down) -> (right, down, right) -> (down, right, right)
'''


def gridtraveler(row, col, memo=dict()):
    key = f'{row}, {col}'
    if key in memo:
        return memo[key]

    if row == 1 and col == 1:
        return 1

    if row == 0 or col == 0:
        return 0

    memo[key] = gridtraveler(row - 1, col) + gridtraveler(row, col - 1)

    return memo[key]


print(gridtraveler(1, 1))  # 1
print(gridtraveler(2, 3))  # 3
print(gridtraveler(3, 2))  # 3
print(gridtraveler(3, 3))  # 6
print(gridtraveler(18, 18))  # 2333606220
print(gridtraveler(50, 50))
