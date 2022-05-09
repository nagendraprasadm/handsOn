package org.nm.lc.hard;

import junit.framework.TestCase;
import org.junit.Test;

public class EditDistanceTest extends TestCase
{
    private EditDistance inst = new EditDistance();

    @Test
    public void testone() {
        //assertEquals(0, inst.editDistance("a", "a"));
        //assertEquals(1, inst.editDistance("a", "b"));
        //assertEquals(1, inst.editDistance("a", "ab"));
        //assertEquals(2, inst.editDistance("ba", "ab"));
        assertEquals(3, inst.editDistance("horse", "ros"));
        //assertEquals(5, inst.editDistance("intention", "execution"));
    }

}