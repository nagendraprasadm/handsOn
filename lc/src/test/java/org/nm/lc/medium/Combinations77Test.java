package org.nm.lc.medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Combinations77Test
{
    Combinations77 inst = new Combinations77();

    @Test
    public void testone() {
        List<List<Integer>> res = inst.combineV3(4, 2);
        assertNotNull(res);
    }
}