package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class MinTimeTypeWordTypeWriter1974Test extends TestCase
{

    private MinTimeTypeWordTypeWriter1974 inst = new MinTimeTypeWordTypeWriter1974();

    @Test
    public void testone() {
        assertEquals(7, inst.minTimeToType("bza"));
    }
}