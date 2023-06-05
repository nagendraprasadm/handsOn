package org.nm.lc.ds;

import junit.framework.TestCase;
import org.junit.Test;

public class UnionFindTest extends TestCase
{

    @Test
    public void testone() {
        UnionFind uf = new UnionFind(2);
        uf.union(0,1);
        assertEquals(uf.find(0), uf.find(1) );
    }

    @Test
    public void testtwo() {
        UnionFind uf = new UnionFind(10);
        uf.union(1,3);
        uf.union(3,5);
        uf.union(5,7);
        uf.union(7,9);
        assertEquals(uf.find(1), uf.find(7) );
        uf.union(2,4);
        uf.union(4,8);
        uf.union(6,10);
        uf.union(6,8);
        assertEquals(uf.find(8), uf.find(10) );
        assertFalse(uf.find(10) == uf.find(1));
        uf.union(3,4);
        assertEquals(uf.find(10), uf.find(1));
        System.out.println(uf.find(10));
        System.out.println(uf.find(1));
    }

}