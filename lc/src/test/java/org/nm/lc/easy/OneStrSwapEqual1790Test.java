package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneStrSwapEqual1790Test
{
    OneStrSwapEqual1790 inst = new OneStrSwapEqual1790();

    @Test
    public void testOne ()
    {
        assertFalse(inst.areAlmostEqual("caa", "aaz"));
    }
}