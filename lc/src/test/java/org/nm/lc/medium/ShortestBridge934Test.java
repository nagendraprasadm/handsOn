package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class ShortestBridge934Test extends TestCase
{

    private ShortestBridge934 inst = new ShortestBridge934();

    @Test
    public void testone(){
        int res = inst.shortestBridge(new int[][]{{0,1}, {1,0}});
        assertEquals(1,res);
    }

    @Test
    public void testtwo(){
        int res = inst.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}});
        assertEquals(2,res);
    }

    @Test
    public void test3(){
        int res = inst.shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}});
        assertEquals(2,res);
    }
}