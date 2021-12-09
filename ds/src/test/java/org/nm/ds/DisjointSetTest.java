package org.nm.ds;

import junit.framework.TestCase;
import org.junit.Test;

public class DisjointSetTest extends TestCase
{

    @Test
    public void testOne ()
    {
        DisjointSet ds = new DisjointSet(2);
        assertEquals(0, ds.findRoot(0));
        assertEquals(1, ds.findRoot(1));
        ds.union(0, 1);
        assertEquals(1, ds.findRoot(0));
        assertEquals(1, ds.findRoot(1));

    }

}