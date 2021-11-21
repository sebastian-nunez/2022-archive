#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
from collections import Counter
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = dict()

        for index, num in enumerate(nums):
            complement = target - num

            if complement in hash_map:
                return [hash_map[complement], index]

            hash_map[num] = index

        return []
