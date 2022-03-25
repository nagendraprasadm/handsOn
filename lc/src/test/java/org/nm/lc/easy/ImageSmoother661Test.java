package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImageSmoother661Test
{
    private ImageSmoother661 inst =  new ImageSmoother661();

    @Test
    public void testOne() {
        int[][] res = inst.imageSmoother(new int[][]{{100,200,100},{200,50,200},{100,200,100}});
        assertNotNull(res);
        assertEquals(res[0][0], 137);
    }
}