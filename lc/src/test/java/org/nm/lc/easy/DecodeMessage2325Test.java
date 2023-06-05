package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class DecodeMessage2325Test extends TestCase
{
    private DecodeMessage2325 inst = new DecodeMessage2325();

    @Test
    public void testone ()
    {
        assertEquals("this is a secret",
                     inst.decodeMessage("the quick brown fox jumps over the lazy dog",
                                        "vkbs bs t suepuv"));
    }

}