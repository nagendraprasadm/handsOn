package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class RepeatDNASequences187Test extends TestCase
{

    RepeatDNASequences187 inst = new RepeatDNASequences187();

    @Test
    public void testone() {
        List<String> res = inst.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        assertEquals(2, res.size());
    }

}