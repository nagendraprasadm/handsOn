package org.nm.lc.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermInString567Test
{
    PermInString567 inst = new PermInString567();

    @Test
    public void testone ()
    {
        assertFalse(inst.checkInclusion("hello", "ooolleoooleh"));
    }
}