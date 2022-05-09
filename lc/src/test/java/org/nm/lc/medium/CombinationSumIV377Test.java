package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class CombinationSumIV377Test extends TestCase
{
    private CombinationSumIV377 inst = new CombinationSumIV377();

    @Test
    public void testone(){
        assertEquals(7, inst.combinationSum4(new int[]{1,2,3}, 4));
    }

}