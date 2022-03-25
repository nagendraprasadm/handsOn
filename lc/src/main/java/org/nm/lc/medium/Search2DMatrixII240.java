package org.nm.lc.medium;

public class Search2DMatrixII240
{

    int[] dir = { 0, 1, 0, -1 };
    int[] dic = { 1, 0, -1, 0 };

    public boolean searchMatrix (int[][] matrix, int target)
    {
        int maxr = matrix.length - 1;
        int maxc = matrix[0].length - 1;
        int lo = 0;
        int hi = maxc;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > matrix[0][mid]) {
                lo = mid + 1;
            }
            else if (target < matrix[0][mid]) {
                hi = mid - 1;
            }
            else if (target == matrix[0][mid]) {
                return true;
            }
        }
        maxc = lo;
        lo = 0;
        hi = maxr;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > matrix[mid][0]) {
                lo = mid + 1;
            }
            else if (target < matrix[mid][0]) {
                hi = mid - 1;
            }
            else if (target == matrix[mid][0]) {
                return true;
            }
        }
        maxr = lo;
        return exists(0, 0, 0, matrix, maxr, maxc, 0, 0, target);

    }

    private boolean exists (int si,
                            int sj,
                            int dii,
                            int[][] matrix,
                            int maxr,
                            int maxc,
                            int minr,
                            int minc,
                            int target)
    {
        if (si >= minr && sj >= minc && si <= maxr && sj <= maxc) {
            boolean isIncreasing = (dii%4) <= 1;
            while (si >= minr && sj >= minc && si <= maxr && sj <= maxc) {
                if (matrix[si][sj] == target) {
                    return true;
                }
                else if (isIncreasing && matrix[si][sj] > target) {
                    break;
                }
                else if (!isIncreasing && matrix[si][sj] < target) {
                    break;
                }
                else {
                    si = si + dir[dii % 4];
                    sj = sj + dic[dii % 4];
                }
            }
            if(dii%4 == 0){
                si = minr;
                sj = maxc;
            }else if(dii%4 == 1){
                si = maxr;
                sj = maxc;
            }else if(dii%4 == 2){
                si = maxr;
                sj = minc;
            }else if(dii%4 == 3){
                si = minr;
                sj = minc;
            }

            if (dii % 4 == 0) {
                minr++;
            }
            else if (dii % 4 == 1) {
                maxc--;
            }
            else if (dii % 4 == 2) {
                maxr--;
            }
            else {
                minc++;
            }

            dii++;
            si = si + dir[dii % 4];
            sj = sj + dic[dii % 4];

            return exists(si, sj , dii, matrix, maxr, maxc,
                          minr, minc, target);
        }
        return false;

    }
}
