def canSum(numbers, target, memo=None):
    """
    Given a array of positive whole numbers, finds if there is a subarray whose sum equals the given target
    """
    if memo == None:
        memo = dict()

    if target in memo:
        return memo[target]

    if target == 0:
        return True

    if target < 0:
        return False

    for num in numbers:
        remainder = target - num

        if canSum(numbers, remainder, memo):
            memo[target] = True
            return True

    memo[target] = False
    return False


print(canSum([2, 3], 7))  # True
print(canSum([5, 4, 4, 7], 7))  # True
print(canSum([2, 4], 7))  # False
print(canSum([2, 3, 5], 8))  # True
print(canSum([7, 14], 300))  # False
