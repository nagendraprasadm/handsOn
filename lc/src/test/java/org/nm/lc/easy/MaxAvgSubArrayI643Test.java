package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxAvgSubArrayI643Test
{

    private MaxAvgSubArrayI643 inst = new MaxAvgSubArrayI643();

    @Test
    public void testOne() {
            double res = inst.findMaxAverage(new int[]{1,12,-5,-6,50,51}, 2);
            assertEquals(55.5, res);
    }
}