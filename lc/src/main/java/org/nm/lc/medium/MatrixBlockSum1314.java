package org.nm.lc.medium;

public class MatrixBlockSum1314
{
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] cf = new int[m][n];
        int[][] cb = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n ;j++){
                if(j == 0){
                    cf[i][j] = mat[i][j];
                }else{
                    cf[i][j] = cf[i][j-1] + mat[i][j];
                    if(j - k > 0){
                        cf[i][j] -= mat[i][j-k-1];
                    }
                }

                if(j == 0){
                    cb[i][n-1] = mat[i][n-1];
                }else{
                    cb[i][n-1-j] = cb[i][n-j] + mat[i][n-1-j];
                    if(n-1-j + k < n - 1){
                        cb[i][n-1-j] -= mat[i][n-j+k];
                    }
                }
            }
        }

        int[][] result = new int[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                result[i][j] = cf[i][j] + cb[i][j] - mat[i][j];
                for(int h = 1; h <= k ; h++){
                    if(i-h >= 0){
                        result[i][j] += cf[i-h][j] + cb[i-h][j] - mat[i-h][j];
                    }
                    if(i+h < m){
                        result[i][j] += cf[i+h][j] + cb[i+h][j] - mat[i+h][j];
                    }
                }
            }
        }

        return result;

    }
}
