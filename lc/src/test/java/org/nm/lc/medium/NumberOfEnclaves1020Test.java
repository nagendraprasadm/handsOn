package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class NumberOfEnclaves1020Test extends TestCase
{
    private NumberOfEnclaves1020 inst = new NumberOfEnclaves1020();

    @Test
    public void testone ()
    {
        assertEquals(3, test(new int[][] { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 },
                                           { 0, 0, 0, 0 } }));
    }

    @Test
    public void testtwo ()
    {
        assertEquals(7, test(new int[][] { { 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
                                                   { 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0 },
                                                   { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0 },
                                                   { 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
                                                   { 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0 },
                                                   { 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
                                                   { 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0 },
                                                   { 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0 },
                                                   { 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
                                                   { 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1 } }));
    }

    private int test (int[][] grid)
    {
        return inst.numEnclaves(grid);
    }

}