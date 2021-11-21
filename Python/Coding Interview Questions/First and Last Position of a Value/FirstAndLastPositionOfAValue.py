# Returns (first, last]) index of target value in the array
#      0  1  2  3  4  5  6  7  8  9  10
arr = [5, 5, 7, 7, 8, 8, 8, 8, 9, 9, 12]
target = 5


# Returns leftmost index of the target
def get_pos(arr, target):
    n = len(arr)
    lower = 0
    upper = n - 1
    pos = n

    while lower <= upper:
        mid = lower + (upper - lower) // 2
        if arr[mid] >= target:
            pos = mid
            upper = mid - 1
        else:
            lower = mid + 1

    return pos


def first_and_last(arr, target):
    first = get_pos(arr, target)
    last = get_pos(arr, target + 1) - 1

    if first <= last:
        return (first, last)

    return (-1, -1)


print(first_and_last(arr, target))
