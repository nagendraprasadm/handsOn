package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class RingsAndRods2103Test extends TestCase
{
    private RingsAndRods2103 inst = new RingsAndRods2103();

    @Test
    public void testone ()
    {
        assertEquals(1, inst.countPoints("B7R5B3G5B1R2B8"));
    }

}