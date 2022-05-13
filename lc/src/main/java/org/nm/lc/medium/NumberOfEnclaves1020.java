package org.nm.lc.medium;

public class NumberOfEnclaves1020
{
    private int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int numEnclaves(int[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int ccnt = dfs(i,j, grid);
                    cnt += ccnt == -1 ? 0 : ccnt;
                }
            }
        }
        return cnt;
    }

    private int dfs(int i, int j, int[][] grid){
        if(isValid(i,j,grid)){
            if(grid[i][j] == 1){
                grid[i][j] = 2;
                int cnt = 1;
                for(int k = 0; k < dir.length; k++){
                    int ocnt = dfs(i + dir[k][0], j + dir[k][1], grid);
                    if(cnt > -1){
                        cnt = ocnt == -1 ? -1 : cnt + ocnt;
                    }
                }
                return cnt;
            }
            return 0;
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
