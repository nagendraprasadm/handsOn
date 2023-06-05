package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class MinMovesCovertStr2027Test extends TestCase
{

    private MinMovesCovertStr2027 inst = new MinMovesCovertStr2027();

    @Test
    public void testone ()
    {
        assertEquals(90, inst.minimumMoves(
            "OXOXXOOXOXXOXXXXOXXXOOXXXXOXXO"));
    }
}