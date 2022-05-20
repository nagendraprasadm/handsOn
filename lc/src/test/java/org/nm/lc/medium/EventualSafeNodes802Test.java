package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class EventualSafeNodes802Test extends TestCase
{
    private EventualSafeNodes802 inst = new EventualSafeNodes802();

    @Test
    public void testOne(){
        List<Integer> res = inst.eventualSafeNodes(new int[][]{ {}, { 0, 2, 3, 4}, { 3}, { 4}, {}});
        assertEquals(5, res.size());
    }
}