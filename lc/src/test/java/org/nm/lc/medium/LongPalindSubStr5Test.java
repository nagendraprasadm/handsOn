package org.nm.lc.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongPalindSubStr5Test
{

    @Test
    public void testone() {
        LongPalindSubStr5 inst = new LongPalindSubStr5();
        String s = inst.longestPalindrome("abcba");
        assertEquals("abcba", s);
    }

    @Test
    public void testtwo() {
        LongPalindSubStr5 inst = new LongPalindSubStr5();
        String s = inst.longestPalindrome("aacabdkacaa");
        assertEquals("aca", s);
    }
}