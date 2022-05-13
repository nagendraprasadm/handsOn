package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class PossibleBiPartition886Test extends TestCase
{
    private PossibleBiPartition886 inst = new PossibleBiPartition886();

    @Test
    public void testone ()
    {
        assertTrue(inst.possibleBipartition(10,
                                            new int[][] { { 4, 7 }, { 4, 8 }, { 5, 6 },
                                                          { 1, 6 }, { 3, 7 }, { 2, 5 },
                                                          { 5, 8 }, { 1, 2 }, { 4, 9 },
                                                          { 6, 10 }, { 8, 10 }, { 3, 6 },
                                                          { 2, 10 }, { 9, 10 }, { 3, 9 },
                                                          { 2, 3 }, { 1, 9 }, { 4, 6 },
                                                          { 5, 7 }, { 3, 8 }, { 1, 8 },
                                                          { 1, 7 }, { 2, 4 } }));
    }

}