package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class CoinChange2Problem518Test extends TestCase
{

    private CoinChange2Problem518 inst = new CoinChange2Problem518();

    @Test
    public void testone ()
    {
        assertEquals(4, inst.change(5, new int[] { 1, 2, 5 }));
    }
}