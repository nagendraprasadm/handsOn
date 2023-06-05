package org.nm.lc.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongSubStrWithOutNonRepChar3Test
{
    LongSubStrWithOutNonRepChar3 inst = new LongSubStrWithOutNonRepChar3();

    @Test
    public void testone(){
        //assertEquals(2, inst.lengthOfLongestSubstring("ab"));
        assertEquals(2, inst.lengthOfLongestSubstringv2("abba"));
    }

    @Test
    public void testver3One(){
        //assertEquals(2, inst.lengthOfLongestSubstring("ab"));
        assertEquals(3, inst.lengthOfLongestSubstring3("abcabcbb"));
    }
}