package org.nm.lc.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateImage48Test
{
    RotateImage48 inst = new RotateImage48();

    @Test
    public void testOne ()
    {
        /*int[][] inp = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        inst.rotate(inp);
        assertEquals(7, inp[0][0]);*/

        int[][] inp = new int[][] { { 1, 2, 3, 4, 5, 6, 7 },
                                    { 8, 9, 10, 11, 12, 13, 14 },
                                    { 15, 16, 17, 18, 19, 20, 21 },
                                    { 22, 23, 24, 25, 26, 27, 28 },
                                    { 29, 30, 31, 32, 33, 34, 35 },
                                    { 36, 37, 38, 39, 40, 41, 42 },
                                    { 43, 44, 45, 46, 47, 48, 49 } };
        inst.rotate(inp);
        assertEquals(43, inp[0][0]);
    }
}