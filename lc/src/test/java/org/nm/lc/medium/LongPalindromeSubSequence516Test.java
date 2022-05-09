package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class LongPalindromeSubSequence516Test extends TestCase
{
    private LongPalindromeSubSequence516 inst = new LongPalindromeSubSequence516();

    @Test
    public void testone() {
        assertEquals(4, inst.longestPalindromeSubseq("bbbab"));

    }

    @Test
    public void testtwo() {
        assertEquals(2, inst.longestPalindromeSubseq("cbbd"));
    }
}