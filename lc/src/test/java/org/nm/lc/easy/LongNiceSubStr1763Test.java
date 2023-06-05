package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class LongNiceSubStr1763Test extends TestCase
{

    private LongNiceSubStr1763 inst = new LongNiceSubStr1763();

    @Test
    public void testone(){
        assertEquals("nN", inst.longestNiceSubstring("FeOZJEnNfjz"));
    }
}