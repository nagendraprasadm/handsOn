package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class DetectPatternLengthTimes1566Test extends TestCase
{
    private DetectPatternLengthTimes1566 inst = new DetectPatternLengthTimes1566();

    @Test
    public void testone ()
    {
        assertTrue(inst.containsPattern(
            new int[] { 3, 2, 1, 3, 3, 2, 1, 3, 3, 1, 2, 3, 3, 2, 1, 3, 2, 1, 1 }, 1, 2));
    }
}