package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class IntervalListIntersections986Test extends TestCase
{
    private IntervalListIntersections986 inst = new IntervalListIntersections986();

    @Test
    public void testOne(){
        int[][] firstL = new int[][]{{14,16}};
        int[][] secondL = new int[][]{{7,13}, {16,20}};
        int[][] res = inst.intervalIntersection(firstL, secondL);
        assertNotNull(res);
        assertTrue(res.length == 1);
    }

}