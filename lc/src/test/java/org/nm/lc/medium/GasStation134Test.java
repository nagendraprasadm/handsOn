package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class GasStation134Test extends TestCase
{
    private GasStation134 inst = new GasStation134();

    @Test
    public void testone(){
        assertEquals(3, inst.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }

    @Test
    public void testtwo(){
        assertEquals(-1, inst.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

}