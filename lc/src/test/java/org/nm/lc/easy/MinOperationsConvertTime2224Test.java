package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class MinOperationsConvertTime2224Test extends TestCase
{
    private MinOperationsConvertTime2224 inst = new MinOperationsConvertTime2224();

    @Test
    public void testone(){
        assertEquals(3, inst.convertTime("02:30", "04:35"));
    }

    @Test
    public void testtwo(){
        assertEquals(4, inst.convertTime("02:30", "04:10"));
    }

    @Test
    public void testthree(){
        assertEquals(25, inst.convertTime("00:59", "23:30"));
    }
}