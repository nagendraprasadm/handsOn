package org.nm.lc.easy;

import junit.framework.TestCase;

public class ThirdMaximumNumber414Test extends TestCase
{

    private ThirdMaximumNumber414 inst = new ThirdMaximumNumber414();

    public void testOne() {
        assertEquals(1, inst.thirdMax(new int[] {1,2,3}));
        assertEquals(1, inst.thirdMax(new int[] {1,2,3,1,2,1,}));
        assertEquals(1, inst.thirdMax(new int[] {1}));
        assertEquals(2, inst.thirdMax(new int[] {1,2}));
    }
}