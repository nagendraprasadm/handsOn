package org.nm.lc.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Search2DMatrixII240Test
{
    private Search2DMatrixII240 inst = new Search2DMatrixII240();

    @Test
    public void testone ()
    {
        /*assertTrue(inst.searchMatrix(
            new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                          { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 26));
        assertTrue(inst.searchMatrix(
            new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                          { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 5));
        assertFalse(inst.searchMatrix(
            new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                          { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 20));
        assertTrue(inst.searchMatrix(
            new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
                          { 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } }, 19));*/
        assertTrue(inst.searchMatrix(
            new int[][] { { 3, 6, 9, 12, 17, 22 }, { 5, 11, 11, 16, 22, 26 },
                          { 10, 11, 14, 16, 24, 31 }, { 10, 15, 17, 17, 29, 31 },
                          { 14, 17, 20, 23, 34, 37 }, { 19, 21, 22, 28, 37, 40 },
                          { 22, 22, 24, 32, 37, 43 } }, 20));
    }
}