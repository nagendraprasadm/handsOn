package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class CountServersCommunicate1267Test extends TestCase
{
    private CountServersCommunicate1267 inst = new CountServersCommunicate1267();

    @Test
    public void testone() {
        assertEquals(3, inst.countServers(new int[][]{{1,0}, {1,1}}));
    }
}