package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;
import org.nm.common.ListUtil;

public class NoOfOpsNtwrkConnected1319Test extends TestCase
{

    private NoOfOpsNtwrkConnected1319 inst = new NoOfOpsNtwrkConnected1319();

    @Test
    public void testone ()
    {
        assertEquals(-1, inst.makeConnected(6, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 },
                                                             { 1, 2 } }));
    }

}