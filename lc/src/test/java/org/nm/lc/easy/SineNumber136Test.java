package org.nm.lc.easy;

import junit.framework.TestCase;

public class SineNumber136Test extends TestCase
{

    private SineNumber136 inst = new SineNumber136();

    public void testOne(){
        int[] nums = new int[]{2,2,1};
        assertEquals(1, inst.singleNumber(nums));
    }
}