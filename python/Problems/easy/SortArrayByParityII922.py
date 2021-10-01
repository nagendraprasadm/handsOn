class Solution(object):
    def sortArrayByParityII(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        evenIdx = [i for i in range(len(nums)) if nums[i]%2 == 0]
        result = [0 for _ in range(len(nums))]
        eIdx = 0
        oIdx = 1
        for i, val in enumerate(nums):
            if (i in evenIdx):
                result[eIdx] = val
                eIdx += 2
            else:
                result[oIdx] = val
                oIdx += 2
        return result

def main():
    soln = Solution()
    soln.sortArrayByParityIIInPlace([3,2,5,6])
if __name__ == "__main__":
    main()