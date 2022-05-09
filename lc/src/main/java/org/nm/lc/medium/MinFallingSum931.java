package org.nm.lc.medium;

public class MinFallingSum931
{
    private int[][] dir = new int[][]{{1,-1}, {1,0}, {1,1}};
    public int minFallingPathSum(int[][] matrix) {
        int minsum = Integer.MAX_VALUE;
        Integer[][] trk = new Integer[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            minFallSum(0,i,matrix,trk);
            minsum = Math.min(minsum, trk[0][i]);
        }
        return minsum;
    }

    private void minFallSum(int i, int j,int[][] matrix, Integer[][] trk){
        //if(i >= 0 && i < matrix.length && j >=0 && j < matrix.length){
        if(trk[i][j] == null){
            int msum = Integer.MAX_VALUE;
            if(j == matrix.length - 1){
                trk[i][j] = matrix[i][j];
            }
            else{
                for(int k = 0; k < dir.length; k++){
                    int ni = i + dir[k][0];
                    int nj = j + dir[k][1];
                    if(ni >= 0 && ni < matrix.length && nj >=0 && nj < matrix.length){
                        minFallSum(i + dir[k][0], j + dir[k][1], matrix, trk);
                        int sum = matrix[i][j] + trk[ni][nj];
                        msum = Math.min(sum, msum);
                    }
                }
                trk[i][j] = msum;
            }

        }
        //  }
    }
}
