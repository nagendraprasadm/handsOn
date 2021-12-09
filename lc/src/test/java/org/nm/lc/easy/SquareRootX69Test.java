package org.nm.lc.easy;

import junit.framework.TestCase;

public class SquareRootX69Test extends TestCase
{
    SquareRootX69 inst = new SquareRootX69();

    public void testInTenThousands() {
        int sqrt = inst.mySqrtBinarySearch(122555);
        assertEquals(350, sqrt);
    }

    public void testMaxInt() {
        int sqrt = inst.mySqrtBinarySearch(Integer.MAX_VALUE);
        assertEquals(46340, sqrt);
    }

    public void testZero() {
        int sqrt = inst.mySqrtBinarySearch(0);
        assertEquals(0, sqrt);
        sqrt = inst.mySqrtBinarySearch(1);
        assertEquals(1, sqrt);
        sqrt = inst.mySqrtBinarySearch(2);
        assertEquals(1, sqrt);
        sqrt = inst.mySqrtBinarySearch(3);
        assertEquals(1, sqrt);
        sqrt = inst.mySqrtBinarySearch(4);
        assertEquals(2, sqrt);
        sqrt = inst.mySqrtBinarySearch(7);
        assertEquals(2, sqrt);
        sqrt = inst.mySqrtBinarySearch(9);
        assertEquals(3, sqrt);
        sqrt = inst.mySqrtBinarySearch(15);
        assertEquals(3, sqrt);
        sqrt = inst.mySqrtBinarySearch(16);
        assertEquals(4, sqrt);
        sqrt = inst.mySqrtBinarySearch(24);
        assertEquals(4, sqrt);
        sqrt = inst.mySqrtBinarySearch(99);
        assertEquals(9, sqrt);
        sqrt = inst.mySqrtBinarySearch(111);
        assertEquals(10, sqrt);

    }
}