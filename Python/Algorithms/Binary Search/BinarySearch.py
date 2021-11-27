def binary_search(data, target):
    lower = 0
    upper = len(data) - 1

    while lower <= upper:
        mid = lower + (upper - lower) // 2

        if data[mid] == target:
            return mid
        elif data[mid] < target:
            lower = mid + 1
        else:
            upper = mid - 1

    return -1


# number_of_cases = int(input('Number of test cases :: '))
# for case in range(number_of_cases):
data = list(map(int, input().split(' ')))
target = int(input())

# print(
# f'The target value "{target}" occurs at index {binary_search(data, target)}.')
print(binary_search(data, target))

"""
TEST CASES:

6
32 42 45 62 73 81 111
32
16 18 34 98
98
30 64 120
64
3 4 6 8 12 13 27
4
12 18 24 26 64
26
9 13 18 21 23
19

"""
