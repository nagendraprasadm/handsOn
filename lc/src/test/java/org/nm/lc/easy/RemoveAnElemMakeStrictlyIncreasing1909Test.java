package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveAnElemMakeStrictlyIncreasing1909Test
{

    RemoveAnElemMakeStrictlyIncreasing1909 inst = new RemoveAnElemMakeStrictlyIncreasing1909();

    @Test
    public void testOne() {
        assertFalse(inst.canBeIncreasing(new int[]{2,3,1,2,4}));
        assertTrue(inst.canBeIncreasing(new int[]{2,3,1,4}));
        assertFalse(inst.canBeIncreasing(new int[]{5,10,4,6}));
        assertTrue(inst.canBeIncreasing(new int[]{3,10,4,6}));
    }
}