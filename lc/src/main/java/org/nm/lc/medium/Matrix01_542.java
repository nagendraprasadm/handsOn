package org.nm.lc.medium;

public class Matrix01_542
{
    public int[][] updateMatrix(int[][] mat) {
        int[][] trk = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j =0; j < mat[0].length; j++){
                trk[i][j] = mat[i][j] == 0 ? 0 : -1;
                if(mat[i][j] == 0){
                    if(isValid(i+1, j , mat.length, mat[0].length) && trk[i+1][j] != 0 && mat[i+1][j] != 0 ){
                        trk[i+1][j] = 1;
                    }
                    if(isValid(i-1, j , mat.length, mat[0].length) && trk[i-1][j] != 0 && mat[i-1][j] != 0){
                        trk[i-1][j] = 1;
                    }
                    if(isValid(i, j-1 , mat.length, mat[0].length) && trk[i][j-1] != 0 && mat[i][j-1] != 0){
                        trk[i][j-1] = 1;
                    }
                    if(isValid(i, j+1 , mat.length, mat[0].length) && trk[i][j+1] != 0 && mat[i][j+1] != 0){
                        trk[i][j+1] = 1;
                    }
                }

            }
        }

        for(int i = 0; i < mat.length; i++){
            for(int j =0; j < mat[0].length; j++){
                rec(i,j,mat, trk, 1);
            }
        }
        return trk;
    }

    private void rec(int i, int j, int[][] mat, int[][] trk, int lvl){
        if(trk[i][j] != -1 ){
            printLog(lvl, "("+i+"," +j+") Value is already set to - " + trk[i][j]);
            return;
        } else if (mat[i][j] == 0){
            printLog(lvl, "("+i+"," +j+") Value is 0 so being set to 0");
            trk[i][j] = 0;
        }
        else {
            printLog(lvl, "("+i+"," +j+") value not set. Calculating....");
            int val = mat[i][j];
            mat[i][j] = -1;
            int min = mat.length * mat[0].length;

            if(isValid(i+1,j,mat.length, mat[0].length) ){
                if(mat[i+1][j] != -1){
                    rec(i+1, j, mat, trk, lvl + 1);
                }   min = Math.min(min, trk[i+1][j]);
            }
            if(min > 0 && isValid(i-1,j,mat.length, mat[0].length)){
                if(mat[i-1][j] != -1) rec(i-1, j, mat, trk, lvl + 1);
                if(trk[i-1][j] != -1) min = Math.min(min, trk[i-1][j]);
            }
            if(min > 0 && isValid(i,j-1,mat.length, mat[0].length)  ){
                if(mat[i][j-1] != -1) rec(i, j-1, mat, trk, lvl + 1);
                min = Math.min(min, trk[i][j-1]);
            }
            if(min > 0 && isValid(i,j+1,mat.length, mat[0].length) ){
                if(mat[i][j+1] != -1) rec(i, j+1, mat, trk, lvl + 1);
                min = Math.min(min, trk[i][j+1]);
            }
            mat[i][j] = val;
            printLog(lvl, "("+i+"," +j+") Value is being set to - " + (min + 1));
            trk[i][j] = min + 1;
        }
    }


    private void printLog(int level , String message) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < level; i++){
            sb.append("-");
        }
        sb.append(message);
        System.out.println(sb.toString());
    }

    public int[][] updateMatrix2(int[][] mat) {
        int lvl = 0;
        int[][] trk = new int[mat.length][mat[0].length];
        int ttl = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0) {
                    trk[i][j] = 0;
                    ttl++;
                }else{
                    trk[i][j] = -1;
                }
            }
        }
        while(true){
            if(ttl >= (mat[0].length * mat.length)){
                break;
            }
            ttl = update(lvl, mat, trk, ttl);
            lvl++;
        }

        return trk;
    }

    private int update(int lvl, int[][] mat, int[][] trk, int ttl){
        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(trk[i][j] == lvl){
                    if(isValid(i+1, j , mat.length, mat[0].length) && trk[i+1][j] == -1){
                        trk[i+1][j] = lvl + 1;
                        ttl++;
                    }
                    if(isValid(i-1, j , mat.length, mat[0].length) && trk[i-1][j] == -1){
                        trk[i-1][j] = lvl + 1;
                        ttl++;
                    }
                    if(isValid(i, j-1 , mat.length, mat[0].length) && trk[i][j-1] == -1){
                        trk[i][j-1] = lvl + 1;
                        ttl++;
                    }
                    if(isValid(i, j+1 , mat.length, mat[0].length) && trk[i][j+1] == -1){
                        trk[i][j+1] = lvl + 1;
                        ttl++;
                    }
                }
            }
        }
        return ttl;
    }

    private boolean isValid(int i, int j, int r, int c){
        return i >=0 && j>= 0 && i < r && j < c;
    }
}
