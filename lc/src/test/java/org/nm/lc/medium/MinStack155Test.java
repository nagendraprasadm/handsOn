package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MinStack155Test extends TestCase
{
    @Test
    public void testone() {
        MinStack155 inst = new MinStack155();
        inst.push(2147483646);
        inst.push(2147483646);
        inst.push(2147483647);
        int top = inst.top();
        assertEquals(2147483647, top);
        inst.pop();
        int min = inst.getMin();
        assertEquals(2147483646, min);
        inst.pop();
        min = inst.getMin();
        assertEquals(2147483646, min);
        inst.pop();
        inst.push(2147483647);
        top = inst.top();
        assertEquals(2147483647, top);
        min = inst.getMin();
        assertEquals(2147483647, min);

        inst.push(-2147483648);
        top = inst.top();
        assertEquals(-2147483648, top);
        min = inst.getMin();
        assertEquals(-2147483648, min);

        inst.pop();
        min = inst.getMin();
        assertEquals(2147483647, min);

    }
}