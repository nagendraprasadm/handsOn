package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementStrstr28Test
{
    ImplementStrstr28 inst = new ImplementStrstr28();

    @Test
    public void testone(){
        assertEquals(4, inst.strStr("mississippi", "issip"));
    }

    @Test
    public void testtwo(){
        assertEquals(9, inst.strStr("mississippi", "pi"));
    }

    @Test
    public void testthree(){
        assertEquals(2, inst.strStr("hello", "ll"));
        assertEquals(0, inst.strStr("hello", ""));
        assertEquals(0, inst.strStr("a", "a"));
        assertEquals(0, inst.strStr("ab", "a"));
        assertEquals(1, inst.strStr("ab", "b"));
        assertEquals(0, inst.strStr("abcdef", "abc"));
        assertEquals(3, inst.strStr("abcdef", "def"));
        assertEquals(2, inst.strStr("abcdefg", "cde"));
        assertEquals(1, inst.strStr("abbcdefg", "b"));
        assertEquals(1, inst.strStr("abbcdefg", "bb"));
        assertEquals(3, inst.strStr("abcbbcbbdefg", "bbcbb"));
    }
}