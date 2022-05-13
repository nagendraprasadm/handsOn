package org.nm.lc.medium;

import org.nm.lc.ds.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinMatrix1091
{
    private static final Logger logger = LoggerFactory.getLogger(ShortestPathInBinMatrix1091.class);

    private int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 0 && grid[n-1][n-1] == 0) {
            boolean[][] trk = new boolean[n][n];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});
            trk[0][0] = true;
            int lvl = 1;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 1; i <= size; i++){
                    int[] cell = queue.poll();
                    int r = cell[0];
                    int c = cell[1];
                    if(r == n-1 && c == n-1){
                        return lvl;
                    }
                    for(int k = 0; k < dir.length; k++){
                        int nr = r + dir[k][0];
                        int nc = c + dir[k][1];
                        if(isValid(nr, nc, grid, trk)){
                            trk[nr][nc] = true;
                            queue.add(new int[]{nr,nc});
                        }
                    }
                }
                lvl++;
            }
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid, boolean[][] trk){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j]  == 0 && !trk[i][j];
    }
}
