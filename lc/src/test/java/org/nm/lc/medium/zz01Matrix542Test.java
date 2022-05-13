package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class zz01Matrix542Test extends TestCase
{
    private zz01Matrix542 inst = new zz01Matrix542();

    @Test
    public void testone(){
        int[][] res = inst.updateMatrix(new int[][]{{0,0,0}, {0,1,0}, {1,1,1}});
        assertNotNull(res);
        assertEquals(res[1][1],1);
    }

}