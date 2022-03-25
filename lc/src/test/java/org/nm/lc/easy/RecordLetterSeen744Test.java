package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordLetterSeen744Test
{
    RecordLetterSeen744 inst = new RecordLetterSeen744();

    @Test
    public void testone() {
        assertEquals('c', inst.nextGreatestLetter(new char[]{'c', 'f','j'}, 'a'));
    }
}