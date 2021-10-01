from functools import reduce

class Solution(object):
    def kWeakestRows(self, mat, k):
        """
        :type mat: List[List[int]]
        :type k: int
        :rtype: List[int]
        """
        dict = {}
        for soldierCount in range(len(mat[0]) + 1):
            dict[soldierCount] = []

        for i, row in enumerate(mat):
            if 0 in row:
                curZeroIdx = row.index(0)
            else:
                curZeroIdx = len(row)
            dict.get(curZeroIdx).append(i)

        result = []
        for key, v in dict.items():
            if len(v) > 0 :
                for soldix in v :
                    result.append(soldix)
        return result[:k]



class Solution2(object):
    def kWeakestRows(self, mat, k):
        """
        :type mat: List[List[int]]
        :type k: int
        :rtype: List[int]
        """
        dict = {}
        for soldierCount in range(len(mat[0]) + 1):
            dict[soldierCount] = []

        for i, row in enumerate(mat):
            curZeroIdx = sum(row)
            dict[curZeroIdx].append(i)

        return reduce(lambda x,y : x + y, dict.values())[:k]

def main():
    soln = Solution();
    matix = [[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]]
    print(soln.kWeakestRows(matix, 3))
    matix = [[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]]
    print(soln.kWeakestRows(matix, 3))

if __name__ == "__main__":
    main()
