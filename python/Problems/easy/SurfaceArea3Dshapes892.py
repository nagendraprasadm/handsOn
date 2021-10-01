class Solution(object):


    def surfaceArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = len(grid)
        columns = len(grid[0])
        area = 0
        for i in range(rows):
            for j in range(columns):
                if i == 0:
                    area += grid[i][j]
                if i > 0:
                    diff = grid[i][j] - grid[i-1][j]
                    if diff > 0 :
                        area += diff
                if i < len(grid) - 1:
                    diff = grid[i][j] - grid[i+1][j]
                    if diff > 0:
                        area += diff
                if i == rows - 1:
                    area += grid[i][j]
                if j == columns - 1:
                    area += grid[i][j]
                if j < columns - 1:
                    diff = grid[i][j] - grid[i][j+1]
                    if diff > 0:
                        area += diff
                if j == 0:
                    area += grid[i][j]
                if j > 0:
                    diff = grid[i][j] - grid[i][j-1]
                    if diff > 0:
                        area += diff
                area += 2 if grid[i][j] > 0 else 0

def main():
    sln  = Solution()
    #sln.surfaceArea([[2]])
    #sln.surfaceArea([[1,0],[0,2]])
    sln.surfaceArea([[2,2,2],[2,1,2],[2,2,2]])


if __name__ == '__main__':
    main()