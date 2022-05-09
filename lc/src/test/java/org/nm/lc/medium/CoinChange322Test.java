package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class CoinChange322Test extends TestCase
{

    private CoinChange322 inst = new CoinChange322();

    @Test
    public void testone ()
    {
        assertEquals(20, inst.coinChange(new int[] { 186, 83, 408 , 419}, 6249));
    }

}