package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class AsFarFromLandPossible1162Test extends TestCase
{
    private AsFarFromLandPossible1162 inst = new AsFarFromLandPossible1162();

    @Test
    public void testone ()
    {
        assertEquals(2, test(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }));
    }

    @Test
    public void testtwo ()
    {
        assertEquals(2, test(new int[][] { { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
                                           { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0 },
                                           { 0, 1, 1, 0, 1, 0, 0, 1, 0, 0 },
                                           { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0 },
                                           { 0, 1, 0, 0, 0, 1, 1, 0, 1, 1 },
                                           { 0, 0, 1, 0, 0, 1, 0, 1, 0, 1 },
                                           { 0, 0, 0, 1, 1, 1, 1, 0, 0, 1 },
                                           { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                                           { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                                           { 1, 1, 0, 1, 1, 1, 1, 1, 0, 0 } }));
    }

    private int test (int[][] input)
    {
        return inst.maxDistance(input);
    }
}