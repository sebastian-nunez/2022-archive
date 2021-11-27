from typing import Dict, List


def canSum(numbers: List[int], target: int, memo: Dict[int, int] = {}) -> bool:
    """Given a array of positive whole numbers, finds if there is a subarray whose sum equals the given target"""
    if target == 0:
        return True

    if target < 0:
        return False

    for num in numbers:
        remainder = target - num

        if canSum(numbers, remainder):
            return True

    return False


print(canSum([2, 3], 7))  # True
print(canSum([5, 4, 4, 7], 7))  # True
print(canSum([2, 4], 7))  # False
print(canSum([2, 3, 5], 8))  # True
print(canSum([7, 14], 300))  # False
print(canSum([1, 4, 5, 9, 12, 64, 120, 6, 120, 99, 121,
      1263, 31781, 12, 31531, 315], 32025))  # True
