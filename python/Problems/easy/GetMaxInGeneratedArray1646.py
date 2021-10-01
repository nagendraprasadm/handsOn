class Solution(object):
    def getMaximumGenerated(self, n):
        """
        :type n: int
        :rtype: int
        """
        result = [0] * (n + 1)
        maxInt = 0
        if n >= 1:
            result[1] = 1
            maxInt = 1
        for i in range(1, (n//2) + 1):
            nextElem = 2 * i
            if nextElem <= n:
                result[nextElem] = result[i]
                maxInt = max(result[nextElem], maxInt)
            nextElem += 1
            if nextElem <= n:
               result[nextElem] = result[i] + result[i+1]
               maxInt = max(result[nextElem], maxInt)
        return maxInt



def main():
    soln = Solution()
    print(soln.getMaximumGenerated(1))

if __name__ == "__main__":
    main()