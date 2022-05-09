package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class UniqueBST96Test extends TestCase
{
    private UniqueBST96 inst = new UniqueBST96();

    @Test
    public void testone() {
        assertEquals(5, inst.numTrees(3));
    }

    @Test
    public void testtwo() {
        assertEquals(14, inst.numTrees(10));
    }

}