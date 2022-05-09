package org.nm.lc.ds;

import junit.framework.TestCase;
import org.junit.Test;

public class MaxPQTest extends TestCase
{

    @Test
    public void testOne() {
        MaxPQ pq = new MaxPQ(5);
        pq.insert(1);
        pq.insert(2);
        pq.insert(3);
        pq.insert(4);
        pq.insert(5);
        assertEquals(5, pq.extractMax());
        assertEquals(4, pq.extractMax());
        assertEquals(3, pq.extractMax());
        assertEquals(2, pq.extractMax());
        assertEquals(1, pq.extractMax());
    }
}