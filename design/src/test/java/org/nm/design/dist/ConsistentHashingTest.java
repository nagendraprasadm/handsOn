package org.nm.design.dist;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConsistentHashingTest extends TestCase
{

    @Test
    public void testOne ()
    {
        List<Integer> nodes = new ArrayList<>();
        nodes.add(1);
        nodes.add(2);
        nodes.add(3);
        nodes.add(4);
        ConsistentHashing<Integer> consistentHashing = new ConsistentHashing(nodes, 200,
                                                                             new HashGenerator());
        assertTrue(1 == consistentHashing.getNode("Bla Bla Bla aksfkbg"));
    }

}