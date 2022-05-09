package org.nm.lc.hard;

import junit.framework.TestCase;
import org.junit.Test;

public class TrapRainWater42Test extends TestCase
{
    private TrapRainWater42 inst = new TrapRainWater42();

    @Test
    public void testone() {
        int trap = inst.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        assertEquals(6, trap);
    }

    @Test
    public void testtwo() {
        int trap = inst.trap(new int[]{4,3,2,1,1,2,1,4});
        assertEquals(14, trap);
    }

    @Test
    public void testthree() {
        int trap = inst.trap(new int[]{4,3,6,2,1,1,5,4,1,4});
        assertEquals(15, trap);
    }

    @Test
    public void testfour() {
        int trap = inst.trap(new int[]{4,2,0,3,2,5});
        assertEquals(9, trap);
    }
}