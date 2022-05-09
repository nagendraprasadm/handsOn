package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class IntegerBreak343Test extends TestCase
{

    private IntegerBreak343 inst = new IntegerBreak343();

    @Test
    public void testone(){
        assertEquals(6, inst.integerBreak(5));
    }
}