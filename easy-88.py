# https://leetcode.com/problems/merge-sorted-array/

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if len(nums2) == 0:
            return nums1
        emptyPointer = m
        i = 0
        j = 0
        while i != m + n and j != n:
            if nums1[i] <= nums2[j]:
                i += 1
            else:
                for shift in range(emptyPointer, i, -1):
                    nums1[shift] = nums1[shift - 1]
                nums1[i] = nums2[j]
                i += 1
                j += 1
                emptyPointer += 1
        if j < n:
            for p in range(j, n):
                nums1[emptyPointer] = nums2[p]
                emptyPointer += 1
        return nums1