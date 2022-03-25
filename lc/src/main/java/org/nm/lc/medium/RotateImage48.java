package org.nm.lc.medium;

import org.apache.commons.lang3.ArrayUtils;

public class RotateImage48
{
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        for(int i = 0; i <= l - 2; i++){
            for(int j = i; j <= l-i-2; j++){
                int maxCnt = 3;
                int[] prev = new int[]{i,j};
                int pv = matrix[i][j];
                int[] cur = new int[2];
                int cnt = 0;
                while(cnt <= maxCnt){
                    cur[0] = prev[1];
                    cur[1] = l - 1 - prev[0];
                    int cv = matrix[cur[0]][cur[1]];
                    matrix[cur[0]][cur[1]] = pv;
                    pv = cv;
                    prev[0] = cur[0];
                    prev[1] = cur[1];
                    cnt++;
                }
                //System.out.println(" i- " + i + ", j - " + j + " and Array is -> " + ArrayUtils.toString(matrix));
            }
        }
    }
}
