package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindPathExistsInGraph1971Test
{
    FindPathExistsInGraph1971 inst = new FindPathExistsInGraph1971();

    @Test
    public void testone ()
    {
        assertTrue(inst.validPath(10,
                                  new int[][] { { 0, 7 }, { 0, 8 }, { 6, 1 }, { 2, 0 },
                                                { 0, 4 }, { 5, 8 }, { 4, 7 }, { 1, 3 },
                                                { 3, 5 }, { 6, 5 } }, 7, 5));
    }
}