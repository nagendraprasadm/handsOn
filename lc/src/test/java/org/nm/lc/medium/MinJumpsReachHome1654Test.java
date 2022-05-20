package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MinJumpsReachHome1654Test extends TestCase
{
    private MinJumpsReachHome1654 inst = new MinJumpsReachHome1654();

    @Test
    public void testone() {
        assertEquals(2, inst.minimumJumps(new int[]{1,6,2,14,5,17,4}, 16,9,7));
    }
}