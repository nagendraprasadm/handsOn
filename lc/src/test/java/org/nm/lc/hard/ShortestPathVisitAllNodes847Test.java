package org.nm.lc.hard;

import junit.framework.TestCase;
import org.junit.Test;

public class ShortestPathVisitAllNodes847Test extends TestCase
{

    private ShortestPathVisitAllNodes847 inst = new ShortestPathVisitAllNodes847();

    @Test
    public void testone() {
        assertEquals(4, inst.shortestPathLength(new int[][]{{1,2,4}, {0}, {0}, {0}}));
    }
}