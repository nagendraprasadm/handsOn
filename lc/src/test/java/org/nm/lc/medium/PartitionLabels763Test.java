package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class PartitionLabels763Test extends TestCase
{
    private PartitionLabels763 inst = new PartitionLabels763();

    @Test
    public void testone(){
        List<Integer> res = inst.partitionLabels("ababcbacadefegdehijhklij");
        assertNotNull(res);
        assertEquals(3, res.size());
    }
}