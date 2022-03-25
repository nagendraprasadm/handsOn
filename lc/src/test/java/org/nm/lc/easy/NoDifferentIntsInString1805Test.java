package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoDifferentIntsInString1805Test
{

    NoDifferentIntsInString1805 inst = new NoDifferentIntsInString1805();

    @Test
    public void testOne ()
    {
        assertEquals(2, inst.numDifferentIntegers(
            "035985750011523523129774573439111590559325a1554234973"));
    }
}