package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxConsecutiveOnes485Test
{

    private MaxConsecutiveOnes485 inst = new MaxConsecutiveOnes485();

    @Test
    public void testOne() {
        int res = inst.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
        assertEquals(3, res);
    }
}