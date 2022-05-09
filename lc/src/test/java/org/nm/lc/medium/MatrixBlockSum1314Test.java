package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MatrixBlockSum1314Test extends TestCase
{
    private MatrixBlockSum1314 inst = new MatrixBlockSum1314();

    @Test
    public void testone ()
    {
        int[][] res = inst.matrixBlockSum(
            new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1);
        assertEquals(12, res[0][0]);
    }
}