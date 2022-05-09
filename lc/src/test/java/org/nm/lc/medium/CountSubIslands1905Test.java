package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class CountSubIslands1905Test extends TestCase
{

    private CountSubIslands1905 inst = new CountSubIslands1905();

    @Test
    public void testone ()
    {
        int res = inst.countSubIslands(
            new int[][] { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 },
                          { 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 } },
            new int[][] { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 },
                          { 1, 0, 1, 1, 0 }, { 0, 1, 0, 1, 0 } });
        assertEquals(3, res);
    }

}