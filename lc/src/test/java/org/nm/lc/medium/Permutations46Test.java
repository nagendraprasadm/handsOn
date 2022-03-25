package org.nm.lc.medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Permutations46Test
{
    Permutations46 inst = new Permutations46();

    @Test
    public void testone(){
        List<List<Integer>> res = inst.permute(new int[]{1,2,3});
        assertNotNull(res);
    }
}