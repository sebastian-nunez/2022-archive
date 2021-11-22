#
# Complete the 'flippingMatrix' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY matrix as parameter.
#

def flippingMatrix(matrix):
    n = len(matrix) - 1

    max_sum = 0
    for i in range(len(matrix) // 2):
        for j in range(len(matrix) // 2):
            top_left = matrix[i][j]
            top_right = matrix[i][n-j]
            bottom_left = matrix[n-i][j]
            bottom_right = matrix[n-i][n-j]

            max_sum += max(top_left, top_right, bottom_left, bottom_right)

    return max_sum
