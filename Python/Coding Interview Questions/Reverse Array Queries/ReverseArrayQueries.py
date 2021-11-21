# Reverse Array Queries: reverse the [lower, upper] region within the input array
arr = [5, 3, 2, 1, 3]
operations = [[0, 1], [1, 3]]


def perform_operations(arr, operations):
    for operation in operations:
        lower = operation[0]
        upper = operation[1]

        while lower <= upper:
            new_lower = arr[upper]
            new_upper = arr[lower]

            arr[lower] = new_lower
            arr[upper] = new_upper

            lower += 1
            upper -= 1

    return arr


# Passing Result: [3, 1, 2, 5, 3]
print(perform_operations(arr, operations))
