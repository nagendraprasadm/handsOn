package org.nm.lc.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateArray189Test
{
    RotateArray189 inst = new RotateArray189();

    @Test
    public void testone() {
        int[] inp = new int[]{1,2,3,4,5,6,7};
        inst.rotate(inp, 7);
        //assertEquals(1, inp[3]);
        //assertEquals(4, inp[6]);
    }
}