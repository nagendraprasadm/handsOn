package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class DegreeOfArray697Test
{
    DegreeOfArray697 inst = new DegreeOfArray697();

    @Test
    public void testOne() {
        int res = inst.findShortestSubArray(new int[]{1,2,3,1,2});
        assertEquals(4, res);
    }

    @Test
    public void testTwo() {
        int res = inst.findShortestSubArray(new int[]{2,1});
        assertEquals(1, res);
    }
}