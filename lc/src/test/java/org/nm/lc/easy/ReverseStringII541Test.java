package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringII541Test
{
    ReverseStringII541 inst = new ReverseStringII541();

    @Test
    public void testOne() {
        String res = inst.reverseStr("abcdefg", 2);
        assertEquals("bacdfeg", res);
         res = inst.reverseStr("abcdefg", 1);
        assertEquals("abcdefg", res);
        res = inst.reverseStr("abcdefg", 3);
        assertEquals("cbadefg", res);
        res = inst.reverseStr("abcdefg", 10);
        assertEquals("gfedcba", res);
        res = inst.reverseStr("abcdefg", 7);
        assertEquals("gfedcba", res);
        res = inst.reverseStr("abcdefg", 6);
        assertEquals("fedcbag", res);

    }
}