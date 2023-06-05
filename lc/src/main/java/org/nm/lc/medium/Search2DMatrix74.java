package org.nm.lc.medium;

public class Search2DMatrix74
{

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int lo = 0;
        int hi = matrix.length - 1;
        int c = matrix[0].length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(target < matrix[mid][c]){
                hi = mid;
            }else if (target > matrix[mid][c]){
                lo = mid + 1;
            }else{
                return true;
            }
        }

        r = lo;
        lo = 0;
        hi = c;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(matrix[r][mid] > target){
                hi = mid - 1;
            }else if(matrix[r][mid] < target){
                lo = mid + 1;
            }else{
                return true;
            }

        }
        return false;
    }
}
