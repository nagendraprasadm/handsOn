package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class XKindDeckCards914Test
{
    XKindDeckCards914 inst = new XKindDeckCards914();

    @Test
    public void testNonCOmmon(){
        assertFalse(inst.hasGroupsSizeX(new int[]{1,1,1,2,2,2,2,2}));
    }
}