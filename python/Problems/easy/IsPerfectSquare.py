class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 1: return True
        l = 0
        h = num
        while l <= h:
            curNum = (l + h) // 2
            val = curNum * curNum
            if val < num:
                l = curNum + 1
            elif val > num:
                h = curNum - 1
            else:
                return True

        return False


def main():
    soln = Solution()
    print(soln.isPerfectSquare(16))
    print(soln.isPerfectSquare(14))
    print(soln.isPerfectSquare(89731987312983791823))


if __name__ == "__main__":
    main()
