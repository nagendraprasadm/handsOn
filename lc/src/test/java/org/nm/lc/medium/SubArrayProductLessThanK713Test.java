package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class SubArrayProductLessThanK713Test extends TestCase
{
    private SubArrayProductLessThanK713 inst = new SubArrayProductLessThanK713();

    @Test
    public void testOne(){
        assertEquals(18, inst.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    }
}