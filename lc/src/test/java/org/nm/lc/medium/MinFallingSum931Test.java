package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MinFallingSum931Test extends TestCase
{

    private MinFallingSum931 inst = new MinFallingSum931();

    @Test
    public void testone() {
        assertEquals(13, inst.minFallingPathSum(new int[][] {{2,1,3}, {6,5,4}, {7,8,9}}));
    }

}