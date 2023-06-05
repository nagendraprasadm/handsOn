package org.nm.lc.medium;

import junit.framework.TestCase;
import org.junit.Test;

public class RemoveDupLetters316Test extends TestCase
{
    private RemoveDupLetters316 inst = new RemoveDupLetters316();

    @Test
    public void testone(){
        assertEquals("acdb", inst.removeDuplicateLetters("cbacdcbc"));
    }

}