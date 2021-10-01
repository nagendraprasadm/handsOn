class Solution(object):
    def canFormArray(self, arr, pieces):
        """
        :type arr: List[int]
        :type pieces: List[List[int]]
        :rtype: bool
        """
        noToIx = {}
        for i in range(len(arr)):
            noToIx[arr[i]] = i

        expCnt = len(arr)
        orignCnt = 0

        for curArr in pieces:
            prevIdx = -1
            orignCnt += len(curArr)
            for curNo in curArr:
                if curNo not in noToIx:
                    return False
                curIdx = noToIx[curNo]
                if (prevIdx != -1 and (curIdx <= prevIdx or curIdx - prevIdx > 1)):
                    return False
                prevIdx = curIdx

        return expCnt == orignCnt


def main():
    soln = Solution()
    #print(soln.canFormArray([37,69,3,74,46]
     #                 ,[[37,69,3,74,46]]))

    print(soln.canFormArray([15,88], [[88], [15]]))
if __name__ == "__main__":
    main()