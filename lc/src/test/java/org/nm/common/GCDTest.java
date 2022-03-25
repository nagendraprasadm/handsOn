package org.nm.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class GCDTest
{
    GCD inst = new GCD();

    @Test
    public void testone()
    {
        int res = inst.findGCD(30,20);
        assertTrue(res > -1);
        res = inst.findGCD(20,30);

    }
}