package org.nm.lc.easy;

import junit.framework.TestCase;

public class RomanToInteger13Test extends TestCase
{
    RomanToInteger13 inst = new RomanToInteger13();

    public void testMCMXCIV ()
    {
        int res = inst.romanToIntVer2("MCMXCIV");
        assertEquals(1994, res);
    }

    public void testIII ()
    {
        int res = inst.romanToIntVer2("III");
        assertEquals(3, res);
    }

    public void testIV ()
    {
        int res = inst.romanToIntVer2("IV");
        assertEquals(4, res);
    }

    public void testVI ()
    {
        int res = inst.romanToIntVer2("VI");
        assertEquals(6, res);
    }
}