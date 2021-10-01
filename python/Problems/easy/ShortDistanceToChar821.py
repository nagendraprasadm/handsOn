class Solution(object):
    def shortestToChar(self, s, c):
        """
        :type s: str
        :type c: str
        :rtype: List[int]
        """
        ixArr = [i for i in range(len(s)) if s[i] == c]
        prevCharIdx = 0
        result = [-1 for i in range(len(s))]

        for i in range(len(s)):
            if i < ixArr[prevCharIdx] or i > ixArr[prevCharIdx]:
                earlierIdx = prevCharIdx if prevCharIdx == 0 else prevCharIdx - 1
                result[i] = min(abs(i - ixArr[prevCharIdx]), abs(i - ixArr[earlierIdx]))
            elif i == ixArr[prevCharIdx]:
                result[i] = 0
                if prevCharIdx < (len(ixArr) - 1):
                    prevCharIdx += 1
        return result


def main():
    soln = Solution()
    print(soln.shortestToChar('loveleetcedo','e'))
    print(soln.shortestToChar('abc','a'))
    print(soln.shortestToChar('a','a'))
    print(soln.shortestToChar('abc','c'))

if __name__ == "__main__":
    main()