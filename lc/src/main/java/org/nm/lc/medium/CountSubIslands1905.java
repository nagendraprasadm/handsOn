package org.nm.lc.medium;

public class CountSubIslands1905
{
    private static final int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ni = 0;
        for(int i = 0; i < grid1.length; i++){
            for(int j = 0; j < grid1[0].length; j++){
                if(grid1[i][j] == 1){
                    rec(i, j, grid1, grid2);
                }
            }
        }

        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] == 2 || grid2[i][j] == 1){
                    if(rec2(i, j, grid2)){
                        ni++;
                    }
                }
            }
        }

        return ni;
    }

    private void rec(int i, int j, int[][] grid, int[][] grid2){
        if(isValid(i, j, grid)){
            grid[i][j] = 2;
            grid2[i][j] = grid2[i][j] == 1 ? 2 : 0;
            for(int k = 0; k < 4; k++){
                rec(i+dir[k][0], j + dir[k][1], grid, grid2);
            }
        }
    }

    private boolean rec2(int i, int j, int[][] grid){
        if(isValid2(i, j, grid)){
            boolean consider = grid[i][j] == 2;
            grid[i][j] = 3;
            for(int k = 0; k < 4; k++){
                boolean considerRep = rec2(i+dir[k][0], j + dir[k][1], grid);
                consider = consider && considerRep;
            }
            return consider;
        }
        return true;
    }

    private boolean isValid(int i, int j, int[][] grid){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }

    private boolean isValid2(int i, int j, int[][] grid){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && (grid[i][j] == 1 || grid[i][j] == 2);
    }
}
