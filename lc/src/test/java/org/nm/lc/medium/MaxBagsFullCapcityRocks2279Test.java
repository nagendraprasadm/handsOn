package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MaxBagsFullCapcityRocks2279Test extends TestCase
{
    private MaxBagsFullCapcityRocks2279 inst = new MaxBagsFullCapcityRocks2279();

    @Test
    public void testone ()
    {
        assertEquals(1,
                     inst.maximumBags(new int[] { 10, 2, 2 }, new int[] { 2, 2, 0 }, 1));
    }

    @Test
    public void testtwo ()
    {

        assertEquals(13, inst.maximumBags(
            new int[] { 54, 18, 91, 49, 51, 45, 58, 54, 47, 91, 90, 20, 85, 20, 90, 49,
                        10, 84, 59, 29, 40, 9, 100, 1, 64, 71, 30, 46, 91 },
            new int[] { 14, 13, 16, 44, 8, 20, 51, 15, 46, 76, 51, 20, 77, 13, 14, 35, 6,
                        34, 34, 13, 3, 8, 1, 1, 61, 5, 2, 15, 18 }, 77));
    }
}