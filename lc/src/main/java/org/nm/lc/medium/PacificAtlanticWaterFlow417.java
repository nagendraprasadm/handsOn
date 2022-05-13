package org.nm.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow417
{
    private int[][] dir = new int[][]{{1,0}, {-1, 0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] trk = new int[heights.length][heights[0].length];
        List<List<Integer>> res = new ArrayList<>();
        trk[0][heights[0].length - 1] = 3;
        trk[heights.length - 1][0] = 3;
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                int val = dfs(i,j,heights,trk);
                if(val == 3){
                    List<Integer> elem = new ArrayList<>();
                    elem.add(i);
                    elem.add(j);
                    res.add(elem);
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] heights, int[][] trk){
        if(isValid(i,j,heights)){
            if(trk[i][j] < 3){
                int val = heights[i][j];
                heights[i][j] = -1;
                int tv = 0;
                for(int k = 0; k < dir.length; k++){
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];
                    boolean isValid = isValid(nr, nc, heights);
                    int cv = 0;
                    if(isValid && heights[nr][nc] <= val){
                        cv = dfs(nr, nc, heights, trk);
                    }else if(nr == -1 || nc == -1){
                        cv = 1;
                    } else if(nr == heights.length || nc == heights[0].length){
                        cv = 2;
                    }
                    if(tv == 0){
                        tv = cv;
                        trk[i][j] = tv;
                    }else if((tv == 1 && cv == 2) || (tv == 2 && cv == 1) || cv == 3){
                        trk[i][j] = 3;
                    }
                    if(trk[i][j] == 3){
                        break;
                    }
                }
                heights[i][j] = val;
            }
            return trk[i][j];
        }
        return 0;
    }

    private boolean isValid(int i, int j, int[][] heights){
        return i >= 0 && j >= 0 && i < heights.length && j < heights[0].length && heights[i][j] > -1;
    }
}
