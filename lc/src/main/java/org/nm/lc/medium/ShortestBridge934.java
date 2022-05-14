package org.nm.lc.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge934
{
    private static final Logger logger = LoggerFactory.getLogger(ShortestBridge934.class);

    private int[][] dir = new int[][]{{1,0},{-1,0}, {0,1}, {0,-1}};

    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i =0; i< grid.length;i++){
            for(int j =0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(i,j, grid, queue, visited);
                    found = true;
                }
                if(found){
                    break;
                }
            }
            if(found){
                break;
            }
        }
        int lvl = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0 ;i < size; i++){
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                //logger.info("{} visited cell - {}, {}.", StringUtil.getHyphens(lvl), r, c);

                for(int k = 0; k < dir.length; k++){
                    int nr = r + dir[k][0];
                    int nc = c + dir[k][1];
                    if(isValid(nr,nc,grid) && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        if(grid[nr][nc] == 1){
                            return lvl;
                        }
                        else{
                            queue.add(new int[]{nr,nc});
                        }
                    }
                }
            }
            lvl++;
        }
        return lvl - 1;
    }

    private void dfs(int i, int j, int[][] grid, Queue<int[]> queue, boolean[][] visited){
        if(isValid(i,j, grid)){
            if(grid[i][j] == 1){
                grid[i][j] = 2;
                visited[i][j] = true;
                queue.add(new int[]{i,j});
                for(int k = 0; k < dir.length; k++){
                    dfs(i + dir[k][0], j + dir[k][1], grid, queue, visited);
                }
            }
        }
    }

    private boolean isValid(int i, int j, int[][] grid){
        return i>= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
