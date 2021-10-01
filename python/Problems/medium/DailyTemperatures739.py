class Solution(object):



    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        result = [0 for i in range(len(temperatures))]
        stack = []
        for i in range(len(temperatures) - 1):
            curTemp = temperatures[i]
            while stack and temperatures[stack[-1]] < curTemp:
                cur = stack.pop()
                result[cur] = i - cur
            stack.append(i)
        return result

    def dailyTemperaturesOld(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        result = [0 for i in range(len(temperatures))]
        for i in range(len(temperatures) - 1):
            curTemp = temperatures[i]
            for j in range(i+1, len(temperatures)):
                nextTemp = temperatures[j]
                if curTemp < nextTemp:
                    result[i] = j - i
                    break
        result[len(temperatures) - 1] = 0
        return result

def main():
    soln = Solution()
    print(soln.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))


if __name__ == '__main__':
    main()