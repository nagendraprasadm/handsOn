class Solution(object):
    def relativeSortArray(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: List[int]
        """
        result = []
        dct = {}
        for elem in arr1:
            if elem in arr2:
                if elem in dct:
                    dct[elem] = dct[elem] + 1
                else:
                    dct[elem] = 1
            else:
                result.append(elem)
        result.sort()
        ix = 0
        for elem in arr2:
            cnt = dct[elem]
            for i in range(cnt):
                result.insert(ix, elem)
                ix += 1
        return result

def main():
    soln = Solution()
    print(soln.relativeSortArray([2,3,1,3,2,4,6,7,9,2,19],[2,1,4,3,9,6]))

if __name__ == "__main__":
    main()