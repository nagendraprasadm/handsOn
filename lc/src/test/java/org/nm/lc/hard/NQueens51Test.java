package org.nm.lc.hard;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class NQueens51Test extends TestCase
{
    private NQueens51 inst = new NQueens51();

    @Test
    public void testone() {
        List<List<String>> res = inst.solveNQueens(1);
        assertNotNull(res);
        assertEquals(1, res.size());
        assertEquals("Q", res.get(0).get(0));
    }

    @Test
    public void testtwo() {
        List<List<String>> res = inst.solveNQueens(2);
        assertNotNull(res);
        assertEquals(0, res.size());
    }

    @Test
    public void testthree() {
        List<List<String>> res = inst.solveNQueens(3);
        assertNotNull(res);
        assertEquals(0, res.size());
    }

    @Test
    public void testfour() {
        List<List<String>> res = inst.solveNQueens(4);
        assertNotNull(res);
        assertEquals(2, res.size());
    }

}