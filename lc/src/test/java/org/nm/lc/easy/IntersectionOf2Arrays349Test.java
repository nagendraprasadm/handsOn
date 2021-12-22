package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class IntersectionOf2Arrays349Test extends TestCase
{
    private IntersectionOf2Arrays349 inst = new IntersectionOf2Arrays349();

    @Test
    public void testOne ()
    {
        int[] res = inst.intersectionWorking4msVer1(new int[] { 4, 2, 3, 1, 8 },
                                                    new int[] { 9, 1, 6, 7, 5, 0, 2 });
        assertTrue(res.length == 2);
        assertEquals(1, res[0]);
        assertEquals(2, res[1]);
    }
}