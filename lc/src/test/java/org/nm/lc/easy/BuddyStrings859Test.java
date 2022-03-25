package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyStrings859Test
{
    BuddyStrings859 inst = new BuddyStrings859();

    @Test
    public void testOne(){
        assertTrue(inst.buddyStrings("ab", "ba"));
    }
}