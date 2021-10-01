import collections
class Solution(object):
    def deleteAndEarnWrong(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        points = 0
        sums = {}
        for num in nums:
            if num in sums:
                sums[num] += num
            else:
                sums[num] = num

        while len(sums) > 0:
            maxnum = -1
            maxval = 0
            for key, value in sums.items():
                if value > maxval:
                    maxval = value
                    maxnum = key
            points += maxnum
            sums[maxnum] -= maxnum
            if sums[maxnum] == 0:
                sums.pop(maxnum)
            if maxnum + 1 in sums:
                sums.pop(maxnum + 1)
            if maxnum - 1 in sums:
                sums.pop(maxnum - 1)
        return points

    def deleteAndEarn(self, nums):
            count = collections.Counter(nums)
            print(f' count - {count} and sorted - {sorted(count)}')
            prev = None
            avoid = using = 0
            for k in sorted(count):

                if k - 1 != prev:
                    avoid, using = max(avoid, using), k * count[k] + max(avoid, using)
                else:
                    avoid, using = max(avoid, using), k * count[k] + avoid
                print(f'k is {k}, prev - {prev}, avoid - {avoid} and using - {using}')
                prev = k
            return max(avoid, using)

def main():
    soln = Solution()
    #print(soln.deleteAndEarn([8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4]))
    print(soln.deleteAndEarn([8,3,4,7,6,6,9,5,8,4,9,5,9,1,5,7,1,4]))

if __name__ == '__main__':
    main()