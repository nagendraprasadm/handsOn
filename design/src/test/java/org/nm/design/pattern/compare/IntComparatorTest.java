package org.nm.design.pattern.compare;

import junit.framework.TestCase;
import org.junit.Test;

public class IntComparatorTest extends TestCase
{
    private IntComparator inst = new IntComparator();
    @Test
    public void testFirstGreater(){
        Integer o1 = 20;
        Integer o2 = 10;
        int nat = o1.compareTo(o2);
        int impl  = inst.compare(o1, o2);
        assertEquals(nat, impl);

    }

}