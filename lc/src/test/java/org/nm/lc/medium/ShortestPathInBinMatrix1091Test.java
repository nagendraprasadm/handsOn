package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class ShortestPathInBinMatrix1091Test extends TestCase
{
    private ShortestPathInBinMatrix1091 inst = new ShortestPathInBinMatrix1091();

    @Test
    public void testone ()
    {
        assertEquals(3, inst.shortestPathBinaryMatrix(
            new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 1, 1, 0 } }));
    }

    @Test
    public void testtwo ()
    {
        assertEquals(8, inst.shortestPathBinaryMatrix(
            new int[][] { { 0, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 1, 0 },
                          { 1, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1 },
                          { 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0 } }));
    }

}