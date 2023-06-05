package org.nm.lc.medium;

public class CountServersCommunicate1267
{
    public int countServers(int[][] grid) {
        int[] r = new int[grid.length];
        int[] c = new int[grid[0].length];
        for(int i =0 ;i< grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int res = 0;
        for(int i =0 ;i< grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j] == 1 && (r[i] + c[j]) > 2){
                    res++;
                }
            }
        }
        return res;
    }
}
