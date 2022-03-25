package org.nm.lc.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqueCharacterString387Test
{
    FirstUniqueCharacterString387 inst = new FirstUniqueCharacterString387();

    @Test
    public void testone ()
    {
        assertEquals(61, inst.firstUniqChar(
            "itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb"));
    }
}