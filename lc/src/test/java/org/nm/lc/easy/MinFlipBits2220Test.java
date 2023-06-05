package org.nm.lc.easy;

import junit.framework.TestCase;

public class MinFlipBits2220Test extends TestCase
{
    MinFlipBits2220 inst = new MinFlipBits2220();

    public void testone ()
    {
        assertEquals(3, inst.minBitFlips(10, 7));
        assertEquals(0, inst.minBitFlips(10, 10));
        assertEquals(2, inst.minBitFlips(0, 10));
    }

}