package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MaxLengthPosProductSubArray1567Test extends TestCase
{
    private MaxLengthPosProductSubArray1567 inst = new MaxLengthPosProductSubArray1567();

    @Test
    public void testone() {
        int res = inst.getMaxLen(new int[]{9,10,1,0,19,20,-28,30,-12,20,11,-8,7,21,-26});
        assertEquals(11, res);
    }
}