class Solution:
    def arrayPairSum(self, nums) -> int:
        nums.sort()
        s = 0
        for i in range(0, len(nums) - 1,2):
            s = s + nums[i]
        #while (i < len(nums) - 1) :
         #   s = s + nums[i]
          #  i += 2
        return s
def main():
    soln = Solution();
    print(soln.arrayPairSum([6,2,6,5,1,2]))


if __name__ == "__main__":
    main()
