package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class MInOperRedXToZero1658Test extends TestCase
{
    private final MInOperRedXToZero1658 inst = new MInOperRedXToZero1658();

    @Test
    public void testone ()
    {
        assertEquals(5, inst.minOperations(new int[] { 3, 2, 20, 1, 1, 3 }, 10));
    }

}