package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class IsomorphicStrings205Test extends TestCase
{
    private IsomorphicStrings205 inst = new IsomorphicStrings205();

    @Test
    public void testone(){
        assertTrue(inst.isIsomorphic("paper", "title"));
    }

    @Test
    public void testtwo(){
        assertFalse(inst.isIsomorphic("foo", "bar"));
    }

    @Test
    public void testthree(){
        assertFalse(inst.isIsomorphic("badc", "baba"));
    }
}