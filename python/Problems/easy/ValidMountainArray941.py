class Solution(object):
    def validMountainArray(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        posfound = False
        negfound = False
        if len(arr) == 1:
            return False
        for i in range(1, len(arr)):
            diff = arr[i] - arr[i-1]
            if diff == 0:
                return False
            elif not posfound:
                if diff < 0 :
                    return False
                else:
                    posfound = True
            elif posfound and not negfound:
                if diff < 0:
                    negfound = True
            elif negfound:
                if diff > 0:
                    return False
        return posfound and negfound


def main():
    soln = Solution()
    print(soln.validMountainArray([0,1,2,1,2]))

if __name__ == "__main__":
    main()