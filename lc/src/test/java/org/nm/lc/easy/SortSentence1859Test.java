package org.nm.lc.easy;

import junit.framework.TestCase;
import org.junit.Test;

public class SortSentence1859Test extends TestCase
{

    private SortSentence1859 inst = new SortSentence1859();

    @Test
    public void testone(){
        assertEquals("This is a sentence", inst.sortSentence("is2 sentence4 This1 a3"));
    }
}