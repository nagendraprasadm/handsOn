package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MinSizeSubArrSum209Test extends TestCase
{
    private MinSizeSubArrSum209 inst = new MinSizeSubArrSum209();

    @Test
    public void testOne(){
        assertEquals(2, inst.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

}