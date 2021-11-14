class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = dict()

        for index, num in enumerate(nums):
            complement = target - num

            if complement in hash_map:
                return [index, hash_map[complement]]

            hash_map[num] = index

        return []
