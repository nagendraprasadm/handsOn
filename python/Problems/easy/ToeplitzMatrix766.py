class Solution(object):

    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        r = len(matrix)
        c = len(matrix[0])
        for i in range(r):
            curRow = i
            curColumn = 0
            prev = matrix[curRow][curColumn]
            print(f'Row Changed - curRow - {curRow}, j - {curColumn} and Current - {prev}')
            curRow = curRow + 1
            curColumn = curColumn + 1

            while curColumn < c and curRow < r:
                cur = matrix[curRow][curColumn]
                print(f'curRow - {curRow}, j - {curColumn}, prev - {prev} and cur - {cur}')
                if cur != prev:
                    return False
                curRow += 1
                curColumn += 1
                prev = cur

        print('Checkng Upper MATRIX')
        for j in range(1, c):
            curColumn = j
            curRow = 0
            prev = matrix[curRow][curColumn]
            print(f'Column Changed - curRow - {curRow}, j - {curColumn} and Current - {prev}')

            curRow = curRow + 1
            curColumn = curColumn + 1
            while curColumn < c and curRow < r:
                cur = matrix[curRow][curColumn]
                print(f'curRow - {curRow}, j - {curColumn}, prev - {prev} and cur - {cur}')
                if cur != prev:
                    return False
                curRow += 1
                curColumn += 1
                prev = cur

        return True


    def isToeplitzMatrixElegant(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        r = len(matrix)
        c = len(matrix[0])
        for i in range(1, r):
            for j in range(1, c):
                if matrix[i][j] != matrix[i-1][j-1]:
                    return False
        return True

def main():
    soln = Solution()
    #print(soln.isToeplitzMatrix([[1, 2, 3], [4, 1, 2], [7, 4, 1]]))
    #print(soln.isToeplitzMatrix([[1]]))
    print(soln.isToeplitzMatrixElegant([[513,64,90,98,34],[91,53,64,90,98],[17,91,53,64,90]]))


if __name__ == "__main__":
    main()
