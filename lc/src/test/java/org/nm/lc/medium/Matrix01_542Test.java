package org.nm.lc.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Matrix01_542Test
{
    Matrix01_542 inst = new Matrix01_542();

    @Test
    public void testone ()
    {
        int[][] res = inst.updateMatrix2(
            new int[][] { { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 1, 0 },
                          { 1, 0, 1, 1, 1 }, { 1, 0, 0, 0, 1 } });
    }
}