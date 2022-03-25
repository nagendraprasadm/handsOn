package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructRectangle492Test
{

    private ConstructRectangle492 inst = new ConstructRectangle492();

    @Test
    public void testOne() {
        int[] res = inst.constructRectangle(6);
        res = inst.constructRectangleOptimized(6);
        assertTrue(res.length > 0);
    }

}