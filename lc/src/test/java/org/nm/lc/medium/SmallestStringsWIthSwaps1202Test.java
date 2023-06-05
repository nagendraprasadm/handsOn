package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SmallestStringsWIthSwaps1202Test extends TestCase
{
    private SmallestStringsWIthSwaps1202 inst = new SmallestStringsWIthSwaps1202();

    @Test
    public void testone ()
    {
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        pair.add(0);
        pair.add(3);
        pairs.add(pair);
        pair = new ArrayList<>();
        pair.add(1);
        pair.add(2);
        pairs.add(pair);
        pair = new ArrayList<>();
        pair.add(0);
        pair.add(2);
        pairs.add(pair);
        assertEquals("abcd", inst.smallestStringWithSwaps("dcab", pairs));
    }

}