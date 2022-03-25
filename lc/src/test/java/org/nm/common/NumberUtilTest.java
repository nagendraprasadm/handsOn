package org.nm.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberUtilTest
{

    @Test
    public void testMax2One() {
        assertEquals(4 , NumberUtil.findSecondMax(new int[]{3,2,5,4,1}));
        assertEquals(4 , NumberUtil.findSecondMax(new int[]{4,3,2,5,1}));
    }
}