package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class UglyNumber263Test
{
    UglyNumber263 inst = new UglyNumber263();

    @Test
    public void testone() {
        //assertFalse(inst.isUgly(2147480000));
        assertTrue(inst.isUgly(6));
    }
}