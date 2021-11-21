import math
import os
import random
import re
import sys


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = dict()

        for index, num in enumerate(nums):
            complement = target - num

            if complement in hash_map:
                return [hash_map[complement], index]

            hash_map[num] = index

        return []


#!/bin/python3


#
# Complete the 'degreeOfArray' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#
def getDegree(arr):
    hash_map = dict()

    for index, num in enumerate(arr):
        if num in hash_map:
            hash_map[num] += 1
        else:
            hash_map[num] = 1

    sortedCount = list(sorted(hash_map.items(), key=lambda x: x[1]))

    return sortedCount[-1][1]


def getSubArrays(arr, degree):
    output = []

    subArray = []
    smallestLength = 1e9 + 5
    for i in range(len(arr)):
        for j in range(i, len(arr)):
            subArray.append(arr[j])

            if getDegree(subArray) == degree and len(subArray) < smallestLength:
                smallestLength = len(subArray)
                output.append(subArray.copy())

        subArray.clear()
    print(output)
    return output


def degreeOfArray(arr):
    # Write your code here
    degree = getDegree(arr)
    subArrays = getSubArrays(arr, degree)

    shortestSubArray = len(subArrays[0])
    for subArray in subArrays:
        if len(subArray) < shortestSubArray:
            shortestSubArray = len(subArray)

    return shortestSubArray


if __name__ == '__main__':
